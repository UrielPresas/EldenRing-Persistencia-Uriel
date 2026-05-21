package Vista;

import DAO.BossDAO;
import DAO.MySQL.MySQLBossDAO;
import Model.Boss;

import java.util.List;

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
}
