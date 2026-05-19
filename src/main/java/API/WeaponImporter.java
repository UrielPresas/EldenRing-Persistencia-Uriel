package API;

import API.DTO.WeaponDTO;
import API.DTO.WeaponResponse;
import DAO.MySQL.MySQLWeaponAttackDAO;
import DAO.MySQL.MySQLWeaponDAO;
import DAO.WeaponAttackDAO;
import DAO.WeaponDAO;
import Model.Weapon;
import Model.WeaponAttack;
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
            //importarDefences(dto);
            //importarScalings(dto);
            //importarRequirements(dto);
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

    }

    private static void importarScalings(WeaponDTO dto){

    }

    private static void importarRequirements(WeaponDTO dto){

    }
}