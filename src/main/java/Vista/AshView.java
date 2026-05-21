package Vista;

import API.DTO.AshOfWarDTO;
import DAO.AshOfWarDAO;
import DAO.MySQL.MySQLAshOfWarDAO;
import Model.AshOfWar;

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
}
