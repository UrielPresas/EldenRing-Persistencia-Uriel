package DAO.MySQL;

import DAO.WeaponAttackDAO;
import Model.WeaponAttack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLWeaponAttackDAO implements WeaponAttackDAO {

    @Override
    public void inserir(Connection conn, WeaponAttack obj) {

        String sql = """
            INSERT INTO weapons_attacks
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
    public void modificar(Connection conn, WeaponAttack obj) {

    }

    @Override
    public void eliminar(Connection conn, WeaponAttack obj) {

    }

    @Override
    public WeaponAttack obtenir(Connection conn, WeaponAttack obj) {
        return null;
    }

    @Override
    public List<WeaponAttack> obtenirTots() {
        return List.of();
    }


    @Override
    public List<WeaponAttack> findByWeaponId(Connection conn, String id) {

        String sql = """
            SELECT *
                FROM weapons_attacks
            WHERE weapon_id = ?
            """;

        List<WeaponAttack> attacks = new ArrayList<>();

        try(PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                WeaponAttack attack = new WeaponAttack();

                attack.setId_attack(
                        rs.getInt("id_attack")
                );

                attack.setWeapon_id(
                        rs.getString("weapon_id")
                );

                attack.setType(
                        rs.getString("type")
                );

                attack.setAmount(
                        rs.getInt("amount")
                );

                attacks.add(attack);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return attacks;
    }
}
