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
}
