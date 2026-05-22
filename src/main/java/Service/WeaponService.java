package Service;

import API.DTO.WeaponDTO;
import API.DTO.WeaponResponse;
import API.EldenRingApiClient;
import API.FileJsonReader;
import DAO.*;
import DAO.MySQL.*;
import API.DTO.WeaponDetailDTO;
import Model.Weapon;
import com.google.gson.Gson;

import java.sql.Connection;

public class WeaponService {

    private WeaponDAO weaponDAO = new MySQLWeaponDAO();
    private WeaponAttackDAO attackDAO = new MySQLWeaponAttackDAO();
    private WeaponDefenceDAO defenceDAO = new MySQLWeaponDefenceDAO();
    private WeaponScalingDAO scalingDAO = new MySQLWeaponScalingDAO();
    private WeaponRequirementDAO requirementDAO = new MySQLWeaponRequirementDAO();

    public Weapon getWeapon(Connection conn, String id){
        return weaponDAO.obtenir(conn, id);
    }

    public WeaponDetailDTO obtenirWeaponComplet(Connection conn, String id){

        WeaponDetailDTO dto = new WeaponDetailDTO();

        dto.setWeapon(
                weaponDAO.obtenir(conn, id)
        );

        dto.setAttacks(
                attackDAO.findByWeaponId(conn, id)
        );

        dto.setDefences(
                defenceDAO.findByWeaponId(conn, id)
        );

        dto.setScalings(
                scalingDAO.findByWeaponId(conn, id)
        );

        dto.setRequirements(
                requirementDAO.findByWeaponId(conn, id)
        );

        return dto;
    }

    public void updateWeapon(Connection conn, Weapon newData, Weapon oldData){

        boolean changes =
                !newData.getName().equals(oldData.getName()) ||
                !newData.getImg().equals(oldData.getImg()) ||
                !newData.getDescription().equals(oldData.getDescription()) ||
                !newData.getCategory().equals(oldData.getCategory()) ||
                newData.getWeight() != oldData.getWeight();

        if(changes){
            weaponDAO.modificar(conn, newData);
        }

    }

    public Weapon getWeaponFromEndpoint(String id){

        String json =
                EldenRingApiClient.getWeaponsJson();

        Gson gson = new Gson();

        WeaponResponse response =
                gson.fromJson(json, WeaponResponse.class);

        for(WeaponDTO dto : response.getData()){

            if(dto.getId().equals(id)){

                Weapon weapon = new Weapon();

                weapon.setId_weapon(dto.getId());
                weapon.setName(dto.getName());
                weapon.setImg(dto.getImage());
                weapon.setDescription(dto.getDescription());
                weapon.setCategory(dto.getCategory());
                weapon.setWeight(dto.getWeight());

                return weapon;
            }

        }
        return null;
    }

    public Weapon getWeaponFromJson(String path, String id){

        String json = FileJsonReader.read(path);

        Gson gson = new Gson();

        WeaponResponse response =
                gson.fromJson(json, WeaponResponse.class);

        for(WeaponDTO dto : response.getData()){

            if(dto.getId().equals(id)){

                Weapon weapon = new Weapon();

                weapon.setId_weapon(dto.getId());
                weapon.setName(dto.getName());
                weapon.setImg(dto.getImage());
                weapon.setDescription(dto.getDescription());
                weapon.setCategory(dto.getCategory());
                weapon.setWeight(dto.getWeight());

                return weapon;
            }
        }

        return null;
    }
}