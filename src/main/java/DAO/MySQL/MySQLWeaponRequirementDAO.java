package DAO.MySQL;

import DAO.Connexions.ConexioFactory;
import DAO.WeaponRequirementDAO;
import Model.WeaponRequirement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySQLWeaponRequirementDAO implements WeaponRequirementDAO {
    @Override
    public void inserir(WeaponRequirement obj) {
        String sql = """
            INSERT INTO weapons_requirements
            (weapon_id, attribute, amount)
            VALUES(?, ?, ?)
            ON DUPLICATE KEY UPDATE
            amount = VALUES(amount)
            """;

        try(Connection conn = ConexioFactory.getConnection("mysql");
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, obj.getWeapon_id());
            ps.setString(2, obj.getAttribute());
            ps.setInt(3, obj.getAmount());

            ps.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(WeaponRequirement obj) {

    }

    @Override
    public void eliminar(Integer integer) {

    }

    @Override
    public WeaponRequirement obtenir(Integer integer) {
        return null;
    }

    @Override
    public List<WeaponRequirement> obtenirTots() {
        return List.of();
    }
}
