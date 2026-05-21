package DAO;

import Model.Weapon;

import java.sql.Connection;

public interface WeaponDAO extends DAO<Weapon, String>{
    Weapon obtenir(Connection conn, String id);
}
