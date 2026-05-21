package DAO.MySQL;

import DAO.Connexions.ConexioFactory;
import DAO.WeaponDefenceDAO;
import Model.WeaponDefence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLWeaponDefenceDAO implements WeaponDefenceDAO {

    @Override
    public void inserir(Connection conn, WeaponDefence obj) {
        String sql = """
                INSERT INTO weapons_defences
                (weapon_id, type, amount)
                VALUES (?, ?, ?)
                ON DUPLICATE KEY UPDATE
                amount = VALUES(amount)
                """;

        try(PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, obj.getWeapon_id());
            ps.setString(2, obj.getType());
            ps.setInt(3, obj.getAmount());

            ps.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Connection conn, WeaponDefence obj) {

    }

    @Override
    public void eliminar(Connection conn, WeaponDefence obj) {

    }

    @Override
    public WeaponDefence obtenir(Connection conn, WeaponDefence obj) {
        return null;
    }

    @Override
    public List<WeaponDefence> obtenirTots() {
        return List.of();
    }


    @Override
    public List<WeaponDefence> findByWeaponId(Connection conn, String id) {

        String sql = """
            SELECT *
                FROM weapons_defences
            WHERE weapon_id = ?
        """;

        List<WeaponDefence> defences = new ArrayList<>();

        try(PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                WeaponDefence defence = new WeaponDefence();

                defence.setId_defence(
                        rs.getInt("id_defence")
                );

                defence.setWeapon_id(
                        rs.getString("weapon_id")
                );

                defence.setType(
                        rs.getString("type")
                );

                defence.setAmount(
                        rs.getInt("amount")
                );

                defences.add(defence);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return defences;
    }
}
