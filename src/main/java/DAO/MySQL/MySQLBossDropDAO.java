package DAO.MySQL;

import DAO.BossDropDAO;
import DAO.Connexions.ConexioFactory;
import Model.BossDrop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLBossDropDAO implements BossDropDAO {
    @Override
    public void inserir(Connection conn, BossDrop obj) {
        String sql = """
                INSERT INTO bosses_drops
                (boss_id, drop_name)
                VALUES (?, ?)
                ON DUPLICATE KEY UPDATE
                drop_name = VALUES(drop_name)
                """;

        try(PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, obj.getBoss_id());
            ps.setString(2, obj.getDrop_name());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modificar(Connection conn, BossDrop obj) {

    }

    @Override
    public void eliminar(Connection conn, BossDrop obj) {

    }

    @Override
    public BossDrop obtenir(Connection conn, BossDrop obj) {
        return null;
    }

    @Override
    public List<BossDrop> obtenirTots() {
        return List.of();
    }


    @Override
    public List<BossDrop> findByBossId(Connection conn, String id) {

        String sql = """
            SELECT *
                FROM bosses_drops
            WHERE boss_id = ?
        """;

        List<BossDrop> drops = new ArrayList<>();

        try(PreparedStatement ps =
                    conn.prepareStatement(sql)) {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                BossDrop drop = new BossDrop();

                drop.setId_drop(
                        rs.getInt("id_drop")
                );

                drop.setBoss_id(
                        rs.getString("boss_id")
                );

                drop.setDrop_name(
                        rs.getString("drop_name")
                );

                drops.add(drop);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return drops;
    }
}
