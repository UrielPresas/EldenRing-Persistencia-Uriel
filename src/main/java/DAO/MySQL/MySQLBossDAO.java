package DAO.MySQL;

import DAO.BossDAO;
import DAO.Connexions.ConexioFactory;
import Model.Boss;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySQLBossDAO implements BossDAO {
    @Override
    public void inserir(Connection conn, Boss obj) {
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

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

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
    public void modificar(Connection conn, Boss obj) {

        String sql = """
                UPDATE bosses
                    SET name = ?,
                        img = ?,
                        region = ?,
                        description = ?,
                        location = ?,
                        health_points = ?
                        last_update = CURRENT_TIMESTAMP
                WHERE id_boss = ?        
                """;

        try(PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, obj.getName());
            ps.setString(2, obj.getImg());
            ps.setString(3, obj.getRegion());
            ps.setString(4, obj.getDescription());
            ps.setString(5, obj.getLocation());
            ps.setString(6, obj.getHealth_points());
            ps.setString(7, obj.getId_boss());

            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Connection conn, Boss obj) {

    }

    @Override
    public Boss obtenir(Connection conn, Boss obj) {
        return null;
    }

    @Override
    public List<Boss> obtenirTots() {
        String sql = """
                SELECT *
                    FROM bosses
                """;

        List<Boss> bList = new ArrayList<>();

        try(Connection conn = ConexioFactory.getConnection("mysql");
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()){

                Boss b = new Boss();

                b.setId_boss(rs.getString("id_boss"));
                b.setName(rs.getString("name"));
                b.setImg(rs.getString("img"));
                b.setRegion(rs.getString("region"));
                b.setDescription(rs.getString("description"));
                b.setLocation(rs.getString("location"));
                b.setHealth_points(rs.getString("health_points"));

                bList.add(b);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return bList;
    }

    @Override
    public Boss obtenir(Connection conn, String id) {

        String sql = """
                SELECT *
                    FROM bosses
                WHERE id_boss = ?
                """;

        try(PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Boss boss = new Boss();

                boss.setId_boss(
                        rs.getString("id_boss")
                );

                boss.setName(
                        rs.getString("name")
                );

                boss.setImg(
                        rs.getString("img")
                );

                boss.setRegion(
                        rs.getString("region")
                );

                boss.setDescription(
                        rs.getString("description")
                );

                boss.setLocation(
                        rs.getString("location")
                );

                boss.setHealth_points(
                        rs.getString("health_points")
                );

                return boss;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<Boss> obtenirTots(Connection conn) {

        String sql = """
            SELECT *
                FROM bosses
            ORDER BY name
        """;

        List<Boss> bosses = new ArrayList<>();

        try(PreparedStatement ps =
                    conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Boss boss = new Boss();

                boss.setId_boss(
                        rs.getString("id_boss")
                );

                boss.setName(
                        rs.getString("name")
                );

                boss.setRegion(
                        rs.getString("region")
                );

                bosses.add(boss);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return bosses;
    }
}
