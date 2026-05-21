package DAO;

import Model.WeaponRequirement;

import java.sql.Connection;
import java.util.List;

public interface WeaponRequirementDAO extends DAO<WeaponRequirement, Integer>{
    List<WeaponRequirement> findByWeaponId(Connection conn, String id);
}
