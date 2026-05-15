package DAO.MySQL;

import DAO.Connexions.ConexioFactory;
import DAO.WeaponDAO;
import Model.Weapon;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.List;

public class MySQLWeaponDAO implements WeaponDAO {

    @Override
    public void inserir(Weapon obj) {
        String sql = """
        INSERT INTO weapons (id_weapon, name, img, description, category, weight)
            VALUES (?, ?, ?, ?, ?, ?)
            ON DUPLICATE KEY UPDATE
                name = VALUES(name),
                img = VALUES(img),
                description = VALUES(description),
                category = VALUES(category),
                weight = VALUES(weight)
        """;

        try(Connection conn = ConexioFactory.getConnection("mysql");
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, obj.getId_weapon());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getImg());
            ps.setString(4, obj.getDescription());
            ps.setString(5, obj.getCategory());
            ps.setDouble(6, obj.getWeight());

            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Weapon obj) {

    }

    @Override
    public void eliminar(String s) {

    }

    @Override
    public Weapon obtenir(String s) {
        return null;
    }

    @Override
    public List<Weapon> obtenirTots() {
        return List.of();
    }
}
