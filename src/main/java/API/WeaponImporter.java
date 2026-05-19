package API;

import API.DTO.WeaponDTO;
import API.DTO.WeaponResponse;
import DAO.*;
import DAO.MySQL.*;
import Model.*;
import com.google.gson.Gson;

public class WeaponImporter {

    public static void importar() {

        String json = EldenRingApiClient.getWeaponsJson();

        if (json == null) {
            System.out.println("Error obtenint JSON");
            return;
        }

        Gson gson = new Gson();

        WeaponResponse response =
                gson.fromJson(json, WeaponResponse.class);

        WeaponDAO weaponDAO = new MySQLWeaponDAO();

        for (WeaponDTO dto : response.getData()) {

            Weapon weapon = convertirDTO(dto);

            weaponDAO.inserir(weapon);

            importarAttacks(dto);
            importarDefences(dto);
            importarScalings(dto);
            importarRequirements(dto);
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

    private static void importarAttacks(WeaponDTO dto){

        WeaponAttackDAO attackDAO = new MySQLWeaponAttackDAO();

        for(var attackDTO : dto.getAttack()){

            WeaponAttack attack = new WeaponAttack();

            attack.setWeapon_id(dto.getId());
            attack.setType(attackDTO.getName());
            attack.setAmount(attackDTO.getAmount());

            attackDAO.inserir(attack);
        }
    }

    private static void importarDefences(WeaponDTO dto){

        WeaponDefenceDAO defenceDAO = new MySQLWeaponDefenceDAO();

        for(var defenceDTO : dto.getDefence()){

            WeaponDefence defence = new WeaponDefence();

            defence.setWeapon_id(dto.getId());
            defence.setType(defenceDTO.getName());
            defence.setAmount(defenceDTO.getAmount());

            defenceDAO.inserir(defence);
        }
    }

    private static void importarScalings(WeaponDTO dto){
        WeaponScalingDAO scalingDAO = new MySQLWeaponScalingDAO();

        for(var scalingDTO : dto.getScalesWith()){

            WeaponScaling scaling = new WeaponScaling();

            scaling.setWeapon_id(dto.getId());
            scaling.setAttribute(scalingDTO.getName());
            scaling.setScaling(scalingDTO.getScaling());

            scalingDAO.inserir(scaling);
        }
    }

    private static void importarRequirements(WeaponDTO dto){

        WeaponRequirementDAO requirementDAO = new MySQLWeaponRequirementDAO();

        for(var requirementDTO : dto.getRequiredAttributes()){

            WeaponRequirement requirement = new WeaponRequirement();

            requirement.setWeapon_id(dto.getId());
            requirement.setAttribute(requirementDTO.getName());
            requirement.setAmount(requirementDTO.getAmount());

            requirementDAO.inserir(requirement);
        }
    }
}