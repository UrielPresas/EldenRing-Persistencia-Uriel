package Service;

import API.DTO.BossDTO;
import API.DTO.BossDetailDTO;
import API.DTO.BossResponse;
import API.EldenRingApiClient;
import API.FileJsonReader;
import DAO.BossDAO;
import DAO.BossDropDAO;
import DAO.MySQL.MySQLBossDAO;
import DAO.MySQL.MySQLBossDropDAO;
import Model.Boss;
import Model.Weapon;
import com.google.gson.Gson;

import java.io.File;
import java.sql.Connection;

public class BossService {

    private BossDAO bossDAO = new MySQLBossDAO();
    private BossDropDAO dropDAO = new MySQLBossDropDAO();

    public Boss getBoss(Connection conn, String id){
        return bossDAO.obtenir(conn, id);
    }

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

    public void updateWeapon(Connection conn, Boss newData, Boss oldData){

        boolean changes =
                !newData.getName().equals(oldData.getName()) ||
                !newData.getImg().equals(oldData.getImg()) ||
                !newData.getRegion().equals(oldData.getRegion()) ||
                !newData.getDescription().equals(oldData.getDescription()) ||
                !newData.getLocation().equals(oldData.getLocation()) ||
                !newData.getHealth_points().equals(oldData.getHealth_points());

        if(changes){
            bossDAO.modificar(conn, newData);
        }
    }

    public Boss getBoosFromEndpoint(String id){

        String json =
                EldenRingApiClient.getBossesJson();

        Gson gson = new Gson();

        BossResponse response =
                gson.fromJson(json, BossResponse.class);

        for(BossDTO dto : response.getData()){

            if(dto.getId().equals(id)){

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

        }
        return null;
    }

    public Boss getBossFromJson(String path, String id){

        String json = FileJsonReader.read(path);

        Gson gson = new Gson();

        BossResponse response =
                gson.fromJson(json, BossResponse.class);

        for(BossDTO dto : response.getData()){

            if(dto.getId().equals(id)){

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

        }
        return null;
    }
}