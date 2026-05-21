package Vista;

import API.DTO.AshOfWarDTO;
import DAO.AshOfWarDAO;
import DAO.MySQL.MySQLAshOfWarDAO;
import Model.AshOfWar;

import java.sql.Connection;
import java.util.List;

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
}
