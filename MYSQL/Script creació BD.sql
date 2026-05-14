SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

CREATE SCHEMA IF NOT EXISTS `ERDB` DEFAULT CHARACTER SET utf8mb4;
USE `ERDB`;

-- =====================================
-- WEAPONS
-- =====================================
CREATE TABLE weapons (
    id_weapon VARCHAR(100) NOT NULL,
    name VARCHAR(100),
    img TEXT,
    description TEXT,
    category VARCHAR(50),
    weight DECIMAL(4,1),

    CONSTRAINT pk_weapons
        PRIMARY KEY (id_weapon)
) ENGINE=InnoDB;

-- =====================================
-- WEAPONS ATTACKS
-- =====================================
CREATE TABLE weapons_attacks (
    id_attack INT NOT NULL AUTO_INCREMENT,
    weapon_id VARCHAR(100) NOT NULL,
    type ENUM('Phy','Mag','Fire','Light','Holy','Crit'),
    amount INT,

    CONSTRAINT pk_weapons_attacks
        PRIMARY KEY (id_attack),

    CONSTRAINT fk_attack_weapon
        FOREIGN KEY (weapon_id)
        REFERENCES weapons(id_weapon)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- =====================================
-- WEAPONS DEFENCES
-- =====================================
CREATE TABLE weapons_defences (
    id_defence INT NOT NULL AUTO_INCREMENT,
    weapon_id VARCHAR(100) NOT NULL,
    type ENUM('Phy','Mag','Fire','Light','Holy','Crit'),
    amount INT,

    CONSTRAINT pk_weapons_defences
        PRIMARY KEY (id_defence),

    CONSTRAINT fk_defence_weapon
        FOREIGN KEY (weapon_id)
        REFERENCES weapons(id_weapon)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- =====================================
-- WEAPONS SCALINGS
-- =====================================
CREATE TABLE weapons_scalings (
    id_scaling INT NOT NULL AUTO_INCREMENT,
    weapon_id VARCHAR(100) NOT NULL,
    attribute ENUM('Vigor','Mind','End','Str','Dex','Int','Faith','Arc'),
    scaling ENUM('S','A','B','C','D','E'),

    CONSTRAINT pk_weapons_scalings
        PRIMARY KEY (id_scaling),

    CONSTRAINT fk_scaling_weapon
        FOREIGN KEY (weapon_id)
        REFERENCES weapons(id_weapon)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- =====================================
-- WEAPONS REQUIREMENTS
-- =====================================
CREATE TABLE weapons_requirements (
    id_requirement INT NOT NULL AUTO_INCREMENT,
    weapon_id VARCHAR(100) NOT NULL,
    attribute ENUM('Vigor','Mind','End','Str','Dex','Int','Faith','Arc'),
    amount INT,

    CONSTRAINT pk_weapons_requirements
        PRIMARY KEY (id_requirement),

    CONSTRAINT fk_requirement_weapon
        FOREIGN KEY (weapon_id)
        REFERENCES weapons(id_weapon)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

-- =====================================
-- ASHES OF WAR
-- =====================================
CREATE TABLE ashes_of_war (
    id_ash VARCHAR(100) NOT NULL,
    name VARCHAR(100),
    img TEXT,
    description TEXT,
    affinity VARCHAR(40),
    skill VARCHAR(80),

    CONSTRAINT pk_ashes
        PRIMARY KEY (id_ash)
) ENGINE=InnoDB;

-- =====================================
-- BOSSES
-- =====================================
CREATE TABLE bosses (
    id_boss VARCHAR(100) NOT NULL,
    name VARCHAR(100),
    img TEXT,
    region VARCHAR(50),
    description TEXT,
    location VARCHAR(100),
    health_points VARCHAR(50),

    CONSTRAINT pk_bosses
        PRIMARY KEY (id_boss)
) ENGINE=InnoDB;

-- =====================================
-- BOSSES DROPS
-- =====================================
CREATE TABLE bosses_drops (
    id_drop INT NOT NULL AUTO_INCREMENT,
    boss_id VARCHAR(100) NOT NULL,
    drop_name VARCHAR(100),

    CONSTRAINT pk_bosses_drops
        PRIMARY KEY (id_drop),

    CONSTRAINT fk_drop_boss
        FOREIGN KEY (boss_id)
        REFERENCES bosses(id_boss)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;