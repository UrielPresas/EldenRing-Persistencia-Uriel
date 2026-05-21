package API;

import API.DTO.BossDTO;
import API.DTO.BossResponse;
import DAO.BossDAO;
import DAO.BossDropDAO;
import DAO.MySQL.MySQLBossDAO;
import DAO.MySQL.MySQLBossDropDAO;
import Model.Boss;
import Model.BossDrop;
import com.google.gson.Gson;

import java.sql.Connection;

public class BossImporter {

    public static void importar(Connection conn, String json){

        Gson gson = new Gson();

        BossResponse response =
                gson.fromJson(json, BossResponse.class);

        BossDAO bossDAO = new MySQLBossDAO();

        for(BossDTO dto : response.getData()){

            Boss boss = convertirDTO(dto);

            bossDAO.inserir(conn, boss);

            importarDrops(conn, dto);

        }

        System.out.println("Bosses Importats");
    }

    private static Boss convertirDTO(BossDTO dto){
        Boss boss = new Boss();

        boss.setId_boss(dto.getId());
        boss.setName(dto.getName());
        boss.setImg(dto.getImage());
        boss.setRegion(dto.getRegion());
        boss.setDescription(dto.getDescription());
        boss.setLocation(dto.getLocation());
        boss.setHealth_points(dto.getHealthPoints());

        return boss;
    }

    private static void importarDrops(Connection conn, BossDTO dto){

        BossDropDAO dropDAO = new MySQLBossDropDAO();

        if(dto.getDrops() == null){
            return;
        }

        for(String drop : dto.getDrops()){

            BossDrop bossDrop = new BossDrop();

            bossDrop.setBoss_id(dto.getId());
            bossDrop.setDrop_name(drop);

            dropDAO.inserir(conn, bossDrop);
        }
    }
}
