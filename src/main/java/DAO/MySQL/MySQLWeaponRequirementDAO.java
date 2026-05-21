package DAO.MySQL;

import API.DTO.WeaponRequirementDTO;
import DAO.Connexions.ConexioFactory;
import DAO.WeaponRequirementDAO;
import Model.WeaponRequirement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLWeaponRequirementDAO implements WeaponRequirementDAO {
    @Override
    public void inserir(Connection conn, WeaponRequirement obj) {
        String sql = """
            INSERT INTO weapons_requirements
            (weapon_id, attribute, amount)
            VALUES(?, ?, ?)
            ON DUPLICATE KEY UPDATE
            amount = VALUES(amount)
            """;

        try(PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, obj.getWeapon_id());
            ps.setString(2, obj.getAttribute());
            ps.setInt(3, obj.getAmount());

            ps.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Connection conn, WeaponRequirement obj) {

    }

    @Override
    public void eliminar(Connection conn, WeaponRequirement obj) {

    }

    @Override
    public WeaponRequirement obtenir(Connection conn, WeaponRequirement obj) {
        return null;
    }

    @Override
    public List<WeaponRequirement> obtenirTots() {
        return List.of();
    }


    @Override
    public List<WeaponRequirement> findByWeaponId(Connection conn, String id) {

        String sql = """
            SELECT *
                FROM weapons_requirements
            WHERE weapon_id = ?
            """;

        List<WeaponRequirement> requirements = new ArrayList<>();

        try(PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                WeaponRequirement requirement= new WeaponRequirement();

                requirement.setId_requirement(
                        rs.getInt("id_requirement")
                );

                requirement.setWeapon_id(
                        rs.getString("weapon_id")
                );

                requirement.setAttribute(
                        rs.getString("attribute")
                );

                requirement.setAmount(
                        rs.getInt("amount")
                );

                requirements.add(requirement);

            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return requirements;
    }
}
