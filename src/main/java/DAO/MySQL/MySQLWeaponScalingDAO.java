package DAO.MySQL;

import DAO.Connexions.ConexioFactory;
import DAO.WeaponScalingDAO;
import Model.WeaponScaling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySQLWeaponScalingDAO implements WeaponScalingDAO {

    @Override
    public void inserir(WeaponScaling obj) {
        String sql = """
            INSERT INTO weapons_scalings
            (weapon_id, attribute, scaling)
            VALUES (?, ?, ?)
            ON DUPLICATE KEY UPDATE
            scaling = VALUES(scaling)
            """;

        try(Connection conn = ConexioFactory.getConnection("mysql");
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, obj.getWeapon_id());
            ps.setString(2, obj.getAttribute());
            ps.setString(3, obj.getScaling());

            ps.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(WeaponScaling obj) {

    }

    @Override
    public void eliminar(Integer integer) {

    }

    @Override
    public WeaponScaling obtenir(Integer integer) {
        return null;
    }

    @Override
    public List<WeaponScaling> obtenirTots() {
        return List.of();
    }
}
