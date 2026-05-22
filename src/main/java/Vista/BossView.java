package Vista;

import API.DTO.BossDetailDTO;
import DAO.BossDAO;
import DAO.MySQL.MySQLBossDAO;
import Model.Boss;
import Service.BossService;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class BossView {

    public static void llistarBosses(){

        BossDAO dao = new MySQLBossDAO();

        List<Boss> bosses = dao.obtenirTots();

        System.out.println("===== BOSSES =====");

        for(Boss b : bosses){
            System.out.println(
                    b.getId_boss() + " | " +
                    b.getName() + " | " +
                    b.getImg() + " | " +
                    b.getRegion() + " | " +
                    b.getDescription() + " | " +
                    b.getLocation() + " | " +
                    b.getHealth_points()
            );
        }
    }

    public static void mostrarAllBosses(Connection conn){

        BossDAO dao = new MySQLBossDAO();

        List<Boss> bosses =
                dao.obtenirTots(conn);

        System.out.println("=== BOSSES ===");

        for(Boss b : bosses){

            System.out.println(
                    b.getId_boss()
                            + " | " +
                            b.getName()
                            + " | " +
                            b.getRegion()
            );
        }
    }

    public static void mostrarBoss(Connection conn, String id){

        BossService service = new BossService();

        BossDetailDTO dto =
                service.obtenirBossComplet(conn, id);

        if(dto.getBoss() == null){
            System.out.println("Boss no trobat");
            return;
        }

        System.out.println("===== BOSS =====");

        System.out.println(dto.getBoss().getName());
        System.out.println(dto.getBoss().getRegion());

        System.out.println("\nDROPS:");

        for(var drop : dto.getDrops()){
            System.out.println("- " + drop.getDrop_name());
        }

    }

    public static void updateBossFlow(Connection conn, String id){

        BossService service = new BossService();

        Scanner sc = new Scanner(System.in);

        System.out.println("""
                1. Endpoint
                2. JSON
                """
        );

        int op = sc.nextInt();
        sc.nextLine();

        Boss external = null;

        if(op == 1){
            external = service.getBoosFromEndpoint(id);
        }
        if(op == 2){
            external = service.getBossFromJson("src/main/resources/bosses.json", id);
        }

        Boss db = service.getBoss(conn, id);

        if(db == null){
            System.out.println("No existeix en la BD");
            return;
        }

        if(external == null){
            System.out.println("Boss no trobat a la font externa");
            return;
        }

        System.out.println("Vols actualitzar (s/n)");

        String opcio = sc.nextLine();

        if(opcio.equalsIgnoreCase("s")){
            service.updateWeapon(conn, external, db);
            System.out.println("Actualitzat");
        }
        else{
            System.out.println("Actualitzacio cancelada");
        }


    }



}
