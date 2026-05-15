package API;

import API.DTO.WeaponDTO;
import API.DTO.WeaponResponse;
import DAO.MySQL.MySQLWeaponDAO;
import DAO.WeaponDAO;
import Model.Weapon;
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

            Weapon weapon = new Weapon();

            weapon.setId_weapon(dto.getId());
            weapon.setName(dto.getName());
            weapon.setImg(dto.getImage());
            weapon.setDescription(dto.getDescription());
            weapon.setCategory(dto.getCategory());
            weapon.setWeight(dto.getWeight());

            weaponDAO.inserir(weapon);
        }

        System.out.println("Importació completada");
    }
}