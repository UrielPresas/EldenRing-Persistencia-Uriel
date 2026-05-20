package DAO.MySQL;

import DAO.AshOfWarDAO;
import DAO.Connexions.ConexioFactory;
import Model.AshOfWar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class MySQLAshOfWarDAO implements AshOfWarDAO {
    @Override
    public void inserir(Connection conn, AshOfWar obj) {
        String sql = """
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
        return List.of();
    }


}
