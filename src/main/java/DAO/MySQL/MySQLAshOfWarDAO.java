package DAO.MySQL;

import DAO.AshOfWarDAO;
import DAO.Connexions.ConexioFactory;
import Model.AshOfWar;
import Model.Weapon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySQLAshOfWarDAO implements AshOfWarDAO {
    @Override
    public void inserir(Connection conn, AshOfWar obj, boolean overwrite) {

        String sql = "";

        if(overwrite) {

            sql = """
                    INSERT INTO ashes_of_war
                    (id_ash, name, img, description, affinity, skill)
                    VALUES (?, ?, ?, ?, ?, ?)
                    ON DUPLICATE KEY UPDATE
                        name = VALUES(name),
                        img = VALUES(img),
                        description = VALUES(description),
                        affinity = VALUES(affinity),
                        skill = VALUES(skill)
                    """;

        }else {
            sql = """
                INSERT IGNORE INTO ashes_of_war
                (id_ash, name, img, description, affinity, skill)
                    VALUES (?, ?, ?, ?, ?, ?)
                """;
        }

        try(PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, obj.getId_ash());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getImg());
            ps.setString(4, obj.getDescription());
            ps.setString(5, obj.getAffinity());
            ps.setString(6, obj.getSkill());

            ps.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Connection conn, AshOfWar obj) {

        String sql = """
            UPDATE ashes_of_war
                SET name = ?
                    img = ?
                    description = ?
                    affinity = ?
                    skill = ?
                    last_update = ?
            """;

        try(PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, obj.getName());
            ps.setString(2, obj.getImg());
            ps.setString(3, obj.getDescription());
            ps.setString(4, obj.getAffinity());
            ps.setString(5, obj.getSkill());
            ps.setString(6, obj.getId_ash());

            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Connection conn, AshOfWar obj) {

    }

    @Override
    public AshOfWar obtenir(Connection conn, AshOfWar obj) {
        return null;
    }

    @Override
    public List<AshOfWar> obtenirTots() {
        String sql = """
                SELECT *
                    FROM ashes_of_war
                """;

        List<AshOfWar> aList = new ArrayList<>();

        try(Connection conn = ConexioFactory.getConnection("mysql");
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()){

                AshOfWar a = new AshOfWar();

                a.setId_ash(rs.getString("id_ash"));
                a.setName(rs.getString("name"));
                a.setId_ash(rs.getString("img"));
                a.setDescription(rs.getString("description"));
                a.setAffinity(rs.getString("affinity"));
                a.setSkill(rs.getString("skill"));

                aList.add(a);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return aList;
    }


    @Override
    public AshOfWar obtenir(Connection conn, String id) {

        String sql = """
            SELECT *
                FROM ashes_of_war
            WHERE id_ash = ?
        """;

        try(PreparedStatement ps =
                    conn.prepareStatement(sql)) {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                AshOfWar ash = new AshOfWar();

                ash.setId_ash(
                        rs.getString("id_ash")
                );

                ash.setName(
                        rs.getString("name")
                );

                ash.setImg(
                        rs.getString("img")
                );

                ash.setDescription(
                        rs.getString("description")
                );

                ash.setAffinity(
                        rs.getString("affinity")
                );

                ash.setSkill(
                        rs.getString("skill")
                );

                return ash;
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<AshOfWar> obtenirTots(Connection conn) {

        String sql = """
            SELECT *
                FROM ashes_of_war
            ORDER BY name
        """;

        List<AshOfWar> ashes = new ArrayList<>();

        try(PreparedStatement ps =
                    conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                AshOfWar ash = new AshOfWar();

                ash.setId_ash(
                        rs.getString("id_ash")
                );

                ash.setName(
                        rs.getString("name")
                );

                ash.setAffinity(
                        rs.getString("affinity")
                );

                ashes.add(ash);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return ashes;
    }

    @Override
    public void inserir(Connection conn, AshOfWar obj) {

    }
}
