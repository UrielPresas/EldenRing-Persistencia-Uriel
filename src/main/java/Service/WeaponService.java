package Service;

import DAO.*;
import DAO.MySQL.*;
import API.DTO.WeaponDetailDTO;

import java.sql.Connection;

public class WeaponService {

    private WeaponDAO weaponDAO = new MySQLWeaponDAO();
    private WeaponAttackDAO attackDAO = new MySQLWeaponAttackDAO();
    private WeaponDefenceDAO defenceDAO = new MySQLWeaponDefenceDAO();
    private WeaponScalingDAO scalingDAO = new MySQLWeaponScalingDAO();
    private WeaponRequirementDAO requirementDAO = new MySQLWeaponRequirementDAO();

    public WeaponDetailDTO obtenirWeaponComplet(Connection conn, String id){

        WeaponDetailDTO dto = new WeaponDetailDTO();

        dto.setWeapon(
                weaponDAO.obtenir(conn, id)
        );

        dto.setAttacks(
                attackDAO.findByWeaponId(conn, id)
        );

        dto.setDefences(
                defenceDAO.findByWeaponId(conn, id)
        );

        dto.setScalings(
                scalingDAO.findByWeaponId(conn, id)
        );

        dto.setRequirements(
                requirementDAO.findByWeaponId(conn, id)
        );

        return dto;
    }
}