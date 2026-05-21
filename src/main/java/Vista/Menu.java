package Vista;

import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);

    public static int mainMenu(){
        int opcio = sc.nextInt();
        System.out.println(
                """
                1. Show DB data
                2. Show data from an external source (Endpoint/JSON)
                3. Update data from the DB
                4. Sync the data
                """
        );
        return opcio;
    }

    public static void dbData(){
        WeaponView.llistarWeapons();
        BossView.llistarBosses();
        AshView.llistarAshes();
    }
}

//            WeaponView.mostrarAllWeapons(conn);
//
//            System.out.println("\nEscriu ID weapon:");
//
//            String id = sc.nextLine();
//
//            WeaponView.mostrarWeapon(conn, id);

//            BossView.mostrarAllBosses(conn);
//
//            System.out.println("\nIntrodueix ID:");
//
//            String id = sc.nextLine();
//
//            BossView.mostrarBoss(conn, id);

//            AshView.mostrarAllAshes(conn);
//
//            System.out.println("\nIntrodueix ID:");
//
//            String id = sc.nextLine();
//
//            AshView.mostrarAsh(conn, id);