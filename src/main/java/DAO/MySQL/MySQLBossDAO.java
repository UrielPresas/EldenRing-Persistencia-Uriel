package DAO.MySQL;

import DAO.BossDAO;
import DAO.Connexions.ConexioFactory;
import Model.Boss;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class MySQLBossDAO implements BossDAO {
    @Override
    public void inserir(Boss obj) {
        String sql = """
                INSERT INTO bosses
                (id_boss, name, img, region, description, location, health_points)
                VALUES(?, ?, ?, ?, ?, ?, ?)
                ON DUPLICATE KEY UPDATE
                    name = VALUES(name),
                    img = VALUES(img),
                    region = VALUES(region),
                    description = VALUES(description),
                    location = VALUES(location),
                    health_points = VALUES (health_points)
                """;

        try (Connection conn = ConexioFactory.getConnection("mysql");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, obj.getId_boss());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getImg());
            ps.setString(4, obj.getRegion());
            ps.setString(5, obj.getDescription());
            ps.setString(6, obj.getLocation());
            ps.setString(7, obj.getHealth_points());

            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void modificar(Boss obj) {

    }

    @Override
    public void eliminar(String s) {

    }

    @Override
    public Boss obtenir(String s) {
        return null;
    }

    @Override
    public List<Boss> obtenirTots() {
        return List.of();
    }
}
