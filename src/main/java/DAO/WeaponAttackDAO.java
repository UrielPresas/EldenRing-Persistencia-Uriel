package DAO;

import Model.WeaponAttack;

import java.sql.Connection;
import java.util.List;

public interface WeaponAttackDAO extends DAO<WeaponAttack, Integer>{
    List<WeaponAttack> findByWeaponId(Connection conn, String id);
}
