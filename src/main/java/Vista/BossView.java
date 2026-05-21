package Vista;

import API.DTO.BossDetailDTO;
import DAO.BossDAO;
import DAO.MySQL.MySQLBossDAO;
import Model.Boss;
import Service.BossService;

import java.sql.Connection;
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

        public static void mostrarBoss(Connection conn, String id) {

            BossService service = new BossService();

            BossDetailDTO dto =
                    service.obtenirBossComplet(conn, id);

            if (dto.getBoss() == null) {
                System.out.println("Boss no trobat");
                return;
            }

            System.out.println("=== BOSS ===");

            System.out.println(
                    dto.getBoss().getName()
            );

            System.out.println(
                    dto.getBoss().getRegion()
            );

            System.out.println(
                    dto.getBoss().getLocation()
            );

            System.out.println("\nDROPS:");

            for (var drop : dto.getDrops()) {

                System.out.println(
                        "- " + drop.getDrop_name()
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

    }
