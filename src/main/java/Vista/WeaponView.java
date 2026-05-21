package Vista;

import API.DTO.WeaponDetailDTO;
import DAO.MySQL.MySQLWeaponDAO;
import DAO.WeaponDAO;
import Model.Weapon;
import Service.WeaponService;

import java.sql.Connection;
import java.util.List;

public class WeaponView {

    public static void llistarWeapons(){

        WeaponDAO dao = new MySQLWeaponDAO();

        List<Weapon> weapons = dao.obtenirTots();

        System.out.println("===== WEAPONS =====");

        for(Weapon w : weapons){
            System.out.println(
                    w.getId_weapon() + " | " +
                    w.getName() + " | " +
                    w.getImg() + " | " +
                    w.getDescription() + " | " +
                    w.getCategory() + " | " +
                    w.getWeight() + " | "
            );
        }
    }

    public static void mostrarWeapon(Connection conn, String id){

        WeaponService service = new WeaponService();

        WeaponDetailDTO dto =
                service.obtenirWeaponComplet(conn, id);

        System.out.println("=== WEAPON ===");

        System.out.println(dto.getWeapon().getName());
        System.out.println(dto.getWeapon().getCategory());

        System.out.println("\nATTACKS:");

        for(var attack : dto.getAttacks()){

            System.out.println(
                    attack.getType() +
                            ": " +
                            attack.getAmount()
            );
        }

        System.out.println("\nSCALINGS:");

        for(var scaling : dto.getScalings()){

            System.out.println(
                    scaling.getAttribute() +
                            ": " +
                            scaling.getScaling()
            );
        }
    }
}
