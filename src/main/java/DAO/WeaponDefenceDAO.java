package DAO;

import Model.WeaponDefence;

import java.sql.Connection;
import java.util.List;

public interface WeaponDefenceDAO extends DAO<WeaponDefence, Integer>{
    List<WeaponDefence> findByWeaponId(Connection conn, String id);
}
