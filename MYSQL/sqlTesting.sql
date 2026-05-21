USE erdb;

SELECT * FROM weapons;
SELECT * FROM erdb.weapons_attacks;

SELECT weapon_id, COUNT(*)
	FROM weapons_attacks
GROUP BY weapon_id;    

SELECT weapon_id, COUNT(*)
	FROM weapons_defences
GROUP BY weapon_id; 

	
SELECT * FROM erdb.weapons;    
SELECT * FROM erdb.weapons_attacks;
SELECT * FROM erdb.weapons_defences;
SELECT * FROM erdb.weapons_requirements;
SELECT * FROM erdb.weapons_scalings;

SELECT * FROM erdb.bosses;
SELECT * FROM erdb.bosses_drops;

SELECT * FROM erdb.ashes_of_war;

ALTER TABLE weapons_attacks
MODIFY COLUMN type VARCHAR(20);

ALTER TABLE weapons_defences
MODIFY COLUMN type VARCHAR(20);

ALTER TABLE weapons_requirements
MODIFY COLUMN attribute VARCHAR(20);

ALTER TABLE weapons_scalings
MODIFY COLUMN attribute VARCHAR(20);

ALTER TABLE weapons_scalings
MODIFY COLUMN scaling VARCHAR(5);

ALTER TABLE weapons_attacks
ADD CONSTRAINT uq_weapon_attack UNIQUE (weapon_id, type);

ALTER TABLE weapons_defences
ADD CONSTRAINT uq_weapon_defence UNIQUE (weapon_id, type);

ALTER TABLE weapons_requirements
ADD CONSTRAINT uq_weapon_requirement UNIQUE (weapon_id, attribute);

ALTER TABLE weapons_scalings
ADD CONSTRAINT uq_weapon_scaling UNIQUE (weapon_id, attribute);

ALTER TABLE bosses_drops
ADD CONSTRAINT uq_boss_drop UNIQUE (boss_id, drop_name);

ALTER TABLE bosses
MODIFY location VARCHAR(255);

TRUNCATE TABLE weapons_defences;
TRUNCATE TABLE weapons_attacks;
TRUNCATE TABLE weapons_requirements;
TRUNCATE TABLE weapons_scalings;
TRUNCATE TABLE weapons;