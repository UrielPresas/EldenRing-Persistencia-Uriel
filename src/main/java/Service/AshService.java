package Service;

import API.DTO.AshOfWarDTO;
import API.DTO.AshResponse;
import API.EldenRingApiClient;
import API.FileJsonReader;
import DAO.AshOfWarDAO;
import DAO.MySQL.MySQLAshOfWarDAO;
import Model.AshOfWar;
import com.google.gson.Gson;

import java.sql.Connection;

public class AshService {

    private AshOfWarDAO ashOfWarDAO = new MySQLAshOfWarDAO();

    public AshOfWar getAsh(Connection conn, String id){
        return ashOfWarDAO.obtenir(conn, id);
    }

    public void updateAshOfWar(Connection conn, AshOfWar newData, AshOfWar oldData){

        boolean changes =
                !newData.getName().equals(oldData.getName()) ||
                !newData.getImg().equals(oldData.getImg()) ||
                !newData.getDescription().equals(oldData.getDescription()) ||
                !newData.getAffinity().equals(oldData.getAffinity()) ||
                !newData.getSkill().equals(oldData.getSkill());

        if(changes){
            ashOfWarDAO.modificar(conn, newData);
        }
    }

    public AshOfWar getAshFromEndpoint(String id){

        String json =
                EldenRingApiClient.getAshesJson();

        Gson gson = new Gson();

        AshResponse response =
                gson.fromJson(json, AshResponse.class);

        for(AshOfWarDTO dto : response.getData()){

            if(dto.getId().equals(id)){

                AshOfWar ashOfWar = new AshOfWar();

                ashOfWar.setId_ash(dto.getId());
                ashOfWar.setName(dto.getName());
                ashOfWar.setImg(dto.getImage());
                ashOfWar.setDescription(dto.getDescription());
                ashOfWar.setAffinity(dto.getAffinity());
                ashOfWar.setSkill(dto.getSkill());

                return ashOfWar;
            }
        }
        return null;
    }

    public AshOfWar getAshFromJson(String path, String id){

        String json = FileJsonReader.read(path);

        Gson gson = new Gson();

        AshResponse response =
                gson.fromJson(json, AshResponse.class);

        for(AshOfWarDTO dto : response.getData()){

            if(dto.getId().equals(id)){

                AshOfWar ashOfWar = new AshOfWar();

                ashOfWar.setId_ash(dto.getId());
                ashOfWar.setName(dto.getName());
                ashOfWar.setImg(dto.getImage());
                ashOfWar.setDescription(dto.getDescription());
                ashOfWar.setAffinity(dto.getAffinity());
                ashOfWar.setSkill(dto.getSkill());

                return ashOfWar;

            }

        }
        return null;
    }
}
