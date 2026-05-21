package DAO;

import Model.WeaponScaling;

import java.sql.Connection;
import java.util.List;

public interface WeaponScalingDAO extends DAO<WeaponScaling, Integer>{
    List<WeaponScaling> findByWeaponId(Connection conn, String id);
}
