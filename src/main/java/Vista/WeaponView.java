package Vista;

import API.DTO.WeaponDetailDTO;
import DAO.MySQL.MySQLWeaponDAO;
import DAO.WeaponDAO;
import Model.Weapon;
import Service.WeaponService;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

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

    public static void mostrarAllWeapons(Connection conn){
        WeaponDAO dao = new MySQLWeaponDAO();

        List<Weapon> weapons =
                dao.obtenirTots(conn);

        System.out.println("=== WEAPONS ===");

        for(Weapon w : weapons){

            System.out.println(
                    w.getId_weapon()
                            + " | " +
                            w.getName()
            );
        }
    }

    public static void mostrarWeapon(Connection conn, String id){

        WeaponService service = new WeaponService();

        WeaponDetailDTO dto =
                service.obtenirWeaponComplet(conn, id);

        if(dto.getWeapon() == null){
            System.out.println("Weapon no trobada");
            return;
        }

        System.out.println("===== WEAPON =====");

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

        System.out.println("\nDEFENCE:");

        for(var defence : dto.getDefences()){

            System.out.println(
                    defence.getType() +
                            ": " +
                            defence.getAmount()
            );
        }

        System.out.println("\nREQUIREMENTS:");

        for(var requirement : dto.getRequirements()){

            System.out.println(
                    requirement.getAttribute() +
                            ": " +
                            requirement.getAmount()
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

    public static void updateWeaponFlow(Connection conn, String id){

        WeaponService service = new WeaponService();

        Scanner sc = new Scanner(System.in);

        System.out.println("""
                1. Endpoint
                2. JSON
                """
        );

        int op = sc.nextInt();
        sc.nextLine();

        Weapon external = null;

        if(op == 1){
            external = service.getWeaponFromEndpoint(id);
        }
        if(op == 2){
            external = service.getWeaponFromJson("src/main/resources/weapons.json", id);
        }

        Weapon db = service.getWeapon(conn, id);

        if(db == null){
            System.out.println("No existeix en la BD");
            return;
        }

        if(external == null){
            System.out.println("Weapon no trobat a la font externa");
            return;
        }

        System.out.println("Vols actualitzar (s/n)");

        String opcio = sc.nextLine();

        if(opcio.equalsIgnoreCase("s")){
            service.updateWeapon(conn, external, db);
            System.out.println("Acutalitzat");
        }
        else{
            System.out.println("Actualitzacio cancelada");
        }
    }

}
