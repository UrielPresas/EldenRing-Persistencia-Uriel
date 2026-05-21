import API.AshImporter;
import API.BossImporter;
import API.WeaponImporter;
import DAO.Connexions.ConexioFactory;
import Vista.WeaponView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//import Vista.Vista;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Escull base de dades (mysql/postgres): ");
        String opcio = sc.nextLine();

        Connection conn = ConexioFactory.getConnection(opcio);

        if (conn == null) {
            System.out.println("Error en la connexió");
            return;
        }

        try {
            conn.setAutoCommit(false);

            WeaponImporter.importar(conn);
            BossImporter.importar(conn);
            AshImporter.importar(conn);

            conn.commit();

            System.out.println("Importació completada");

            WeaponView.mostrarWeapon(conn, "17f6946481al0i1olr8v9h8hxdx439");

            //Vista.WeaponView.llistarWeapons();
            //Vista.AshView.llistarAshes();
            //Vista.BossView.llistarBosses();

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("Rollback executat");
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}