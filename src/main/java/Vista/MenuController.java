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

            switch(op){

                case 1:
                    Menu.dbData(conn);
                    break;

                case 2:
                    externalData(conn);
                    break;

                case 3:
                    updateById(conn);
                    break;

                case 4:
                    syncData(conn);
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

        int op = Integer.parseInt(sc.nextLine());

        String json = null;

        if(type.equalsIgnoreCase("weapons")){

            json = (op == 1)
                    ? EldenRingApiClient.getWeaponsJson()
                    : FileJsonReader.read("src/main/resources/weapons.json");

            WeaponImporter.importar(conn, json, true);
        }

        if(type.equalsIgnoreCase("bosses")){

            json = (op == 1)
                    ? EldenRingApiClient.getBossesJson()
                    : FileJsonReader.read("src/main/resources/bosses.json");

            BossImporter.importar(conn, json, true);
        }

        if(type.equalsIgnoreCase("ashes")){

            json = (op == 1)
                    ? EldenRingApiClient.getAshesJson()
                    : FileJsonReader.read("src/main/resources/ashes.json");

            AshImporter.importar(conn, json, true);
        }

        System.out.println("Import finished");
    }

    private static void updateById(Connection conn){

        System.out.println("WEAPONS / BOSSES / ASHES?");
        String type = sc.nextLine();

        if(type.equalsIgnoreCase("WEAPONS")){
            WeaponView.mostrarAllWeapons(conn);
        }
        else if(type.equalsIgnoreCase("BOSSES")){
            BossView.mostrarAllBosses(conn);
        }
        else if(type.equalsIgnoreCase("ASHES")){
            AshView.mostrarAllAshes(conn);
        }
        else{
            System.out.println("Opció incorrecta");
        }

        System.out.println("Enter ID:");
        String id = sc.nextLine();

        if(type.equalsIgnoreCase("weapons")){

            WeaponView.updateWeaponFlow(conn, id);
        }

        if(type.equalsIgnoreCase("bosses")){

            BossView.updateBossFlow(conn, id);
        }

        if(type.equalsIgnoreCase("ashes")){

            AshView.updateAshOfWarFlow(conn, id);
        }
    }

    private static void syncData(Connection conn){

        System.out.println("WEAPONS / BOSSES / ASHES?");
        String type = sc.nextLine();

        System.out.println("1. Endpoint");
        System.out.println("2. JSON");

        int source = sc.nextInt();
        sc.nextLine();

        System.out.println("1. Partial copy");
        System.out.println("2. Full sync");

        int sync = sc.nextInt();
        sc.nextLine();

        boolean overwrite = (sync == 2);

        String json = null;

        if(type.equalsIgnoreCase("weapons")){

            json = (source == 1)
                    ? EldenRingApiClient.getWeaponsJson()
                    : FileJsonReader.read("src/main/resources/weapons.json");

            WeaponImporter.importar(conn, json, overwrite);
        }

        if(type.equalsIgnoreCase("bosses")){

            json = (source == 1)
                    ? EldenRingApiClient.getBossesJson()
                    : FileJsonReader.read("src/main/resources/bosses.json");

            BossImporter.importar(conn, json, overwrite);
        }

        if(type.equalsIgnoreCase("ashes")){

            json = (source == 1)
                    ? EldenRingApiClient.getAshesJson()
                    : FileJsonReader.read("src/main/resources/ashes.json");

            AshImporter.importar(conn, json, overwrite);
        }

        System.out.println("Sync completed");
    }
}