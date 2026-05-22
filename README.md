# EldenRing-Persistencia-Uriel

Aquest projecte està orientat principalment a treballar conceptes de persistència, importació de dades externes, consistència transaccional i arquitectura DAO utilitzant Java i JDBC.

Més que centrar-se en el contingut de Elden Ring, el projecte busca resoldre problemes típics de sincronització i persistència de dades provinents d’una API externa.

---

# Arquitectura utilitzada

El projecte està separat en diferents capes:

- API
- DTO
- Model
- DAO
- Service
- Vista

La separació es va fer per evitar acoblament directe entre:
- la font externa
- la lògica de negoci
- la persistència

Això facilita:
- manteniment
- escalabilitat
- reutilització
- substitució de fonts de dades

---

# Per què utilitzar DTOs

Es van utilitzar DTOs perquè l’estructura de l’API no coincideix necessàriament amb l’estructura de la base de dades.

Això permet:
- desacoblar l’API del model intern
- validar dades abans de persistir-les
- transformar dades externes
- tolerar millor canvis en l’API

Exemple:
- `WeaponDTO`
- `BossDTO`
- `AshDTO`

Posteriorment aquestes dades es transformen en models interns:
- `Weapon`
- `Boss`
- `AshOfWar`

---

# Per què NO utilitzar DTO en BossDrop

Inicialment es va crear un `BossDropDTO`.

Posteriorment es va eliminar perquè l’API retorna els drops com una llista de Strings simples:

```json
"drops": [
    "Golden Halberd"
]
````

No existeix un objecte JSON complex que justifiqui un DTO.

Eliminar aquest DTO:

* simplifica el codi
* redueix classes innecessàries
* fa l’importador més mantenible

---

# Problema dels ENUM

Inicialment es van utilitzar ENUMs a MySQL per camps com:

* `type`
* `attribute`

El problema va aparèixer quan l’API va retornar valors inesperats com:

```text
Rng
```

Això provocava errors de persistència:

```text
Data truncated for column
```

Finalment es va substituir ENUM per `VARCHAR`.

## Avantatges del VARCHAR

* més escalable
* tolerant a canvis externs
* menys manteniment de base de dades
* evita errors si l’API canvia

## Inconvenients

* menys control estricte dels valors
* es poden guardar dades incorrectes si no es validen

En aquest cas es va prioritzar flexibilitat davant control estricte perquè les dades provenen d’una font externa no controlada.

---

# Ús d’una sola connexió i transaccions

Inicialment cada DAO obria i tancava la seva pròpia connexió.

Això provocava un problema greu de consistència:

Si un import fallava a meitat del procés:

* algunes taules quedaven actualitzades
* altres no
* podien existir registres orfes

Per solucionar-ho es va modificar el sistema perquè tots els imports comparteixin:

* una sola connexió
* una sola transacció

Mitjançant:

* `commit`
* `rollback`

---

# Avantatges de la transacció única

## Consistència total

Si una part falla:

* no es guarda res parcial
* rollback automàtic
* integritat referencial garantida

## Millor arquitectura ETL

El flux passa a ser:

1. Extract
2. Transform
3. Load

## Millor control d’errors

Els errors es gestionen de forma centralitzada.

## Facilita ampliacions futures

Permet implementar més fàcilment:

* logging
* mètriques
* sincronització avançada
* validacions globals

---

# Inconvenients de la transacció única

## Major complexitat

Ara és necessari passar `Connection` entre capes.

## DAO menys independents

Els DAO depenen d’una connexió externa.

## Transaccions més llargues

La base de dades manté locks durant més temps.

## Debug més delicat

Un únic error pot provocar rollback complet.

---

# Per què utilitzar ON DUPLICATE KEY UPDATE

Es va utilitzar:

```sql
ON DUPLICATE KEY UPDATE
```

per implementar sincronització i evitar duplicats.

Això permet:

* inserir nous registres
* actualitzar existents
* evitar consultes prèvies addicionals

## Avantatges

* menys consultes SQL
* millor rendiment
* sincronització més simple

## Inconvenients

* pot actualitzar dades innecessàriament
* complica mètriques exactes de inserts vs updates

---

# Control d’errors implementat

El projecte contempla:

* errors de connexió amb l’endpoint
* JSON incorrectes
* estructures inesperades
* dades null
* errors de persistència SQL

Abans de persistir dades:

* es validen camps obligatoris
* es comprova l’estructura
* es realitza mapeig de dades

---

# Sincronització parcial vs completa

Es van implementar dos modes.

## Partial Copy

Només insereix registres nous.

Avantatge:

* menys modificacions
* menys càrrega

## Full Sync

Sobreescriu dades existents.

Avantatge:

* base de dades totalment sincronitzada

Inconvenient:

* més costós
* pot actualitzar dades sense canvis reals

---

# Millores futures

## Logging

No es va implementar per falta de temps.

La idea seria registrar:

* inserts
* updates
* errors
* temps d’importació
* registres ignorats

Mitjançant:

* `Logger`
* fitxers `.log`

---

# Sincronització de taules filles

Actualment la sincronització completa només afecta taules principals.

No sincronitza completament:

* attacks
* defences
* scalings
* requirements
* drops

Per fer-ho correctament caldria:

1. comparar dades antigues i noves
2. eliminar registres obsolets
3. inserir registres nous
4. mantenir consistència referencial

Això augmenta considerablement la complexitat del sistema.

---

# Conclusió

El projecte ha servit principalment per treballar:

* persistència
* arquitectura DAO
* importació de dades externes
* transaccions
* sincronització
* consistència de dades
* desacoblament entre capes
