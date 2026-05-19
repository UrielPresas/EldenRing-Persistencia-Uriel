package API;

import API.DTO.BossDTO;
import API.DTO.BossResponse;
import DAO.BossDAO;
import DAO.BossDropDAO;
import DAO.MySQL.MySQLBossDAO;
import DAO.MySQL.MySQLBossDropDAO;
import Model.Boss;
import com.google.gson.Gson;

public class BossImporter {

    public static void importar(){

        String json = EldenRingApiClient.getWeaponsBosses();

        if (json == null) {
            System.out.println("Error obtenint JSON");
            return;
        }

        Gson gson = new Gson();

        BossResponse response =
                gson.fromJson(json, BossResponse.class);

        BossDAO bossDAO = new MySQLBossDAO();

        for(BossDTO dto : response.getData()){

            Boss boss = convertirDTO(dto);

            bossDAO.inserir(boss);

            importarDrops(dto);

        }

        System.out.println("Importació completada");
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

    private static void importarDrops(BossDTO dto){

        BossDropDAO dropDAO = new MySQLBossDropDAO();

        for(var dropDTO : dto.getDrops()){

        }
    }
}
