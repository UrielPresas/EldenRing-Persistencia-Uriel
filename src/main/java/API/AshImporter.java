package API;

import API.DTO.AshOfWarDTO;
import API.DTO.AshResponse;
import DAO.AshOfWarDAO;
import DAO.MySQL.MySQLAshOfWarDAO;
import Model.AshOfWar;
import com.google.gson.Gson;

import java.sql.Connection;

public class AshImporter {

    public static void importar(Connection conn, String json){

        Gson gson = new Gson();

        AshResponse response =
                gson.fromJson(json, AshResponse.class);

        AshOfWarDAO ashDAO =
                new MySQLAshOfWarDAO();

        for(AshOfWarDTO dto : response.getData()){

            AshOfWar ash = convertirDTO(dto);

            ashDAO.inserir(conn, ash);
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
