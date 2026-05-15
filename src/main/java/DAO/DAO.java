package DAO;

import java.util.List;

// T == Tipus d'objecte (Candidat, Via, Sector...)
// K == Tipus de clau primaria (Long, String, int, Float...)
public interface DAO<T, ID> {
    void inserir(T obj);
    void modificar(T obj);
    void eliminar(ID id);
    T obtenir(ID id);
    List<T> obtenirTots();
}
