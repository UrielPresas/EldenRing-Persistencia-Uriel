import API.*;
import DAO.Connexions.ConexioFactory;
import Vista.AshView;
import Vista.BossView;
import Vista.MenuController;
import Vista.WeaponView;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Escull base de dades (mysql/postgres): ");
        String opcio = sc.nextLine();

        Connection conn = ConexioFactory.getConnection(opcio);

        if(conn == null){
            System.out.println("Error en la connexió");
            return;
        }

        try {
            conn.setAutoCommit(false);

            MenuController.run(conn);

            conn.commit();

        } catch(Exception e){

            try {
                conn.rollback();
            } catch(Exception ex){
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            try {
                conn.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}