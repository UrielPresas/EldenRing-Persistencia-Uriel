package Vista;

import API.DTO.AshOfWarDTO;
import DAO.AshOfWarDAO;
import DAO.MySQL.MySQLAshOfWarDAO;
import Model.AshOfWar;
import Service.AshService;

import java.sql.Connection;
import java.util.List;
import java.util.NavigableSet;
import java.util.Scanner;

public class AshView {

    public static void llistarAshes(){

        AshOfWarDAO dao = new MySQLAshOfWarDAO();

        List<AshOfWar> ashes = dao.obtenirTots();

        System.out.println("===== ASHES OF WAR =====");

        for(AshOfWar a : ashes){
            System.out.println(
                    a.getId_ash() + " | " +
                    a.getName() + " | " +
                    a.getImg() + " | " +
                    a.getDescription() + " | " +
                    a.getAffinity() + " | " +
                    a.getSkill()
            );
        }
    }

    public static void mostrarAllAshes(Connection conn){

        AshOfWarDAO dao = new MySQLAshOfWarDAO();

        List<AshOfWar> ashes =
                dao.obtenirTots(conn);

        System.out.println("=== ASHES OF WAR ===");

        for(AshOfWar a : ashes){

            System.out.println(
                    a.getId_ash()
                            + " | " +
                            a.getName()
                            + " | " +
                            a.getAffinity()
            );
        }
    }

    public static void mostrarAsh(Connection conn, String id){

        AshOfWarDAO dao = new MySQLAshOfWarDAO();

        AshOfWar ash = dao.obtenir(conn, id);

        if(ash == null){
            System.out.println("Ash no trobada");
            return;
        }

        System.out.println("=== ASH OF WAR ===");

        System.out.println(
                ash.getName()
        );

        System.out.println(
                ash.getAffinity()
        );

        System.out.println(
                ash.getSkill()
        );

        System.out.println(
                ash.getDescription()
        );
    }

    public static void updateAshOfWarFlow(Connection conn, String id){

        AshService service = new AshService();

        Scanner sc = new Scanner(System.in);

        System.out.println("""
                1. Endpoint
                2. JSON
                """
        );

        int op = sc.nextInt();
        sc.nextLine();

        AshOfWar external = null;

        if(op == 1){
            external = service.getAshFromEndpoint(id);
        }
        if(op == 2){
            external = service.getAshFromJson("src/main/resources/ashes.json", id);
        }

        AshOfWar db = service.getAsh(conn ,id);

        if(db == null){
            System.out.println("No existeix en la BD");
        }

        if(external == null){
            System.out.println("Ash Of War no trobada a la font externa");
            return;
        }

        System.out.println("Vols actualitzar (s/n)");

        String opcio = sc.nextLine();

        if(opcio.equalsIgnoreCase("s"))
        {
            service.updateAshOfWar(conn, external, db);
            System.out.println("Actualitzat");
        }
        else{
            System.out.println("Actualitzacio cancelada");
        }
    }
}
