package API;

import API.DTO.WeaponDTO;
import API.DTO.WeaponResponse;
import DAO.*;
import DAO.MySQL.*;
import Model.*;
import com.google.gson.Gson;

import java.sql.Connection;

public class WeaponImporter {

    public static void importar(Connection conn, String json, boolean overwrite) {

        Gson gson = new Gson();

        WeaponResponse response =
                gson.fromJson(json, WeaponResponse.class);

        if(response == null ||
                response.getData() == null){

            System.out.println(
                    "Error en l'estructura de dades"
            );

            return;
        }

        WeaponDAO weaponDAO = new MySQLWeaponDAO();

        for (WeaponDTO dto : response.getData()) {

            Weapon weapon = convertirDTO(dto);

            if(dto.getId() == null ||
                    dto.getName() == null){

                System.out.println(
                        "Weapon ignorada: dades incorrectes"
                );

                continue;
            }

            weaponDAO.inserir(conn, weapon, overwrite);

            importarAttacks(conn, dto);
            importarDefences(conn, dto);
            importarScalings(conn, dto);
            importarRequirements(conn, dto);
        }

        System.out.println("Importació completada");
    }

    private static Weapon convertirDTO(WeaponDTO dto){
        Weapon weapon = new Weapon();

        weapon.setId_weapon(dto.getId());
        weapon.setName(dto.getName());
        weapon.setImg(dto.getImage());
        weapon.setDescription(dto.getDescription());
        weapon.setCategory(dto.getCategory());
        weapon.setWeight(dto.getWeight());

        return weapon;
    }

    private static void importarAttacks(Connection conn, WeaponDTO dto){

        WeaponAttackDAO attackDAO = new MySQLWeaponAttackDAO();

        for(var attackDTO : dto.getAttack()){

            WeaponAttack attack = new WeaponAttack();

            attack.setWeapon_id(dto.getId());
            attack.setType(attackDTO.getName());
            attack.setAmount(attackDTO.getAmount());

            attackDAO.inserir(conn, attack);
        }
    }

    private static void importarDefences(Connection conn, WeaponDTO dto){

        WeaponDefenceDAO defenceDAO = new MySQLWeaponDefenceDAO();

        for(var defenceDTO : dto.getDefence()){

            WeaponDefence defence = new WeaponDefence();

            defence.setWeapon_id(dto.getId());
            defence.setType(defenceDTO.getName());
            defence.setAmount(defenceDTO.getAmount());

            defenceDAO.inserir(conn, defence);
        }
    }

    private static void importarScalings(Connection conn, WeaponDTO dto){
        WeaponScalingDAO scalingDAO = new MySQLWeaponScalingDAO();

        for(var scalingDTO : dto.getScalesWith()){

            WeaponScaling scaling = new WeaponScaling();

            scaling.setWeapon_id(dto.getId());
            scaling.setAttribute(scalingDTO.getName());
            scaling.setScaling(scalingDTO.getScaling());

            scalingDAO.inserir(conn, scaling);
        }
    }

    private static void importarRequirements(Connection conn, WeaponDTO dto){

        WeaponRequirementDAO requirementDAO = new MySQLWeaponRequirementDAO();

        for(var requirementDTO : dto.getRequiredAttributes()){

            WeaponRequirement requirement = new WeaponRequirement();

            requirement.setWeapon_id(dto.getId());
            requirement.setAttribute(requirementDTO.getName());
            requirement.setAmount(requirementDTO.getAmount());

            requirementDAO.inserir(conn, requirement);
        }
    }
}