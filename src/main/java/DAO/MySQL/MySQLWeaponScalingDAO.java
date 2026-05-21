package DAO.MySQL;

import DAO.Connexions.ConexioFactory;
import DAO.WeaponScalingDAO;
import Model.WeaponScaling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLWeaponScalingDAO implements WeaponScalingDAO {

    @Override
    public void inserir(Connection conn, WeaponScaling obj) {
        String sql = """
            INSERT INTO weapons_scalings
            (weapon_id, attribute, scaling)
            VALUES (?, ?, ?)
            ON DUPLICATE KEY UPDATE
            scaling = VALUES(scaling)
            """;

        try(PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, obj.getWeapon_id());
            ps.setString(2, obj.getAttribute());
            ps.setString(3, obj.getScaling());

            ps.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Connection conn, WeaponScaling obj) {

    }

    @Override
    public void eliminar(Connection conn, WeaponScaling obj) {

    }

    @Override
    public WeaponScaling obtenir(Connection conn, WeaponScaling obj) {
        return null;
    }

    @Override
    public List<WeaponScaling> obtenirTots() {
        return List.of();
    }


    @Override
    public List<WeaponScaling> findByWeaponId(Connection conn, String id) {

        String sql = """
            SELECT *
                FROM weapons_scalings
            WHERE weapon_id = ?
            """;

        List<WeaponScaling> scalings = new ArrayList<>();

        try(PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                WeaponScaling scaling = new WeaponScaling();

                scaling.setId_scaling(
                        rs.getInt("id_scaling")
                );

                scaling.setWeapon_id(
                        rs.getString("weapon_id")
                );

                scaling.setAttribute(
                        rs.getString("attribute")
                );

                scaling.setScaling(
                        rs.getString("scaling")
                );

                scalings.add(scaling);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return scalings;
    }
}
