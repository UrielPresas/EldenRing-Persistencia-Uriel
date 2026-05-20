package API;

import API.DTO.AshOfWarDTO;
import API.DTO.AshResponse;
import DAO.AshOfWarDAO;
import DAO.MySQL.MySQLAshOfWarDAO;
import Model.AshOfWar;
import com.google.gson.Gson;

public class AshImporter {

    public static void importar(){

        String json =
                EldenRingApiClient.getAshesJson();

        if(json == null){
            System.out.println("Error obtenint JSON");
            return;
        }

        Gson gson = new Gson();

        AshResponse response =
                gson.fromJson(json, AshResponse.class);

        AshOfWarDAO ashDAO =
                new MySQLAshOfWarDAO();

        for(AshOfWarDTO dto : response.getData()){

            AshOfWar ash = convertirDTO(dto);

            ashDAO.inserir(ash);
        }

        System.out.println("Ashes importades");
    }

    private static AshOfWar convertirDTO(AshOfWarDTO dto){

        AshOfWar ash = new AshOfWar();

        ash.setId_ash(dto.getId());
        ash.setName(dto.getName());
        ash.setImg(dto.getImage());
        ash.setDescription(dto.getDescription());
        ash.setAffinity(dto.getAffinity());
        ash.setSkill(dto.getSkill());

        return ash;
    }
}
