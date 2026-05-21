package Vista;

import java.sql.Connection;
import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);

    public static void showMenu(){

        System.out.println("""
            ===== MENU =====
            1. Show DB data
            2. Show external data
            3. Update data
            4. Sync data
            0. Exit
        """);
    }

    public static int readOption(){
        return sc.nextInt();
    }

    public static void dbData(Connection conn){

        System.out.println("===== DATABASE DATA =====");

        System.out.println("\n--- WEAPONS ---");
        WeaponView.mostrarAllWeapons(conn);

        System.out.println("\n--- BOSSES ---");
        BossView.mostrarAllBosses(conn);

        System.out.println("\n--- ASHES ---");
        AshView.mostrarAllAshes(conn);
    }
}