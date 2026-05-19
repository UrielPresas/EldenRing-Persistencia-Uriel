package DAO.MySQL;

import DAO.Connexions.ConexioFactory;
import DAO.WeaponAttackDAO;
import Model.WeaponAttack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySQLWeaponAttackDAO implements WeaponAttackDAO {

    @Override
    public void inserir(WeaponAttack obj) {

        String sql = """
            INSERT INTO weapons_attacks
            (weapon_id, type, amount)
            VALUES (?, ?, ?)
            ON DUPLICATE KEY UPDATE
            amount = VALUES(amount)
            """;

        try(Connection conn = ConexioFactory.getConnection("mysql");
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, obj.getWeapon_id());
            ps.setString(2, obj.getType());
            ps.setInt(3, obj.getAmount());

            ps.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(WeaponAttack obj) {

    }

    @Override
    public void eliminar(Integer integer) {

    }

    @Override
    public WeaponAttack obtenir(Integer integer) {
        return null;
    }

    @Override
    public List<WeaponAttack> obtenirTots() {
        return List.of();
    }
}
