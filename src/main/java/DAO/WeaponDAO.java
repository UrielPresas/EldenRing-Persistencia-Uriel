package DAO;

import Model.Weapon;

import java.sql.Connection;
import java.util.List;

public interface WeaponDAO extends DAO<Weapon, String>{
    Weapon obtenir(Connection conn, String id);
    List<Weapon> obtenirTots(Connection conn);
    void inserir(Connection conn, Weapon obj, boolean overwrite);
}
