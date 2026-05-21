package Vista;

import Vista.*;
import DAO.Connexions.ConexioFactory;

import java.sql.Connection;
import java.util.Scanner;

import API.*;

public class MenuController {

    static Scanner sc = new Scanner(System.in);

    public static void run(Connection conn){

        boolean exit = false;

        while(!exit){

            Menu.showMenu();

            int op = Menu.readOption();
            sc.nextLine();

            switch(op){

                case 1:
                    Menu.dbData(conn);
                    break;

                case 2:
                    externalData(conn);
                    break;

                case 3:
                    System.out.println("Update (next step)");
                    break;

                case 4:
                    System.out.println("Sync (next step)");
                    break;

                case 0:
                    exit = true;
                    break;
            }
        }
    }

    private static void externalData(Connection conn){

        System.out.println("WEAPONS / BOSSES / ASHES?");
        String type = sc.nextLine();

        System.out.println("1. Endpoint");
        System.out.println("2. JSON");

        int op = sc.nextInt();
        sc.nextLine();

        String json = null;

        if(type.equalsIgnoreCase("weapons")){

            json = (op == 1)
                    ? EldenRingApiClient.getWeaponsJson()
                    : FileJsonReader.read("src/main/resources/weapons.json");

            WeaponImporter.importar(conn, json);
        }

        if(type.equalsIgnoreCase("bosses")){

            json = (op == 1)
                    ? EldenRingApiClient.getBossesJson()
                    : FileJsonReader.read("src/main/resources/bosses.json");

            BossImporter.importar(conn, json);
        }

        if(type.equalsIgnoreCase("ashes")){

            json = (op == 1)
                    ? EldenRingApiClient.getAshesJson()
                    : FileJsonReader.read("src/main/resources/ashes.json");

            AshImporter.importar(conn, json);
        }

        System.out.println("Import finished");
    }
}