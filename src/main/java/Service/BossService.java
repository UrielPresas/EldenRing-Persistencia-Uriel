package Service;

import API.DTO.BossDetailDTO;
import DAO.BossDAO;
import DAO.BossDropDAO;
import DAO.MySQL.MySQLBossDAO;
import DAO.MySQL.MySQLBossDropDAO;

import java.sql.Connection;

public class BossService {

    private BossDAO bossDAO = new MySQLBossDAO();
    private BossDropDAO dropDAO = new MySQLBossDropDAO();

    public BossDetailDTO obtenirBossComplet(Connection conn, String id){

        BossDetailDTO dto = new BossDetailDTO();

        dto.setBoss(
                bossDAO.obtenir(conn, id)
        );

        dto.setDrops(
                dropDAO.findByBossId(conn, id)
        );

        return dto;
    }
}