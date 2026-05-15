import API.EldenRingApiClient;
import DAO.Connexions.ConexioFactory;
import java.sql.Connection;
import java.util.Scanner;

//import Vista.Vista;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Escull base de dades (mysql/postgres): ");
        String opcio = sc.nextLine();

        Connection conn = ConexioFactory.getConnection(opcio);

        if(conn != null){
            System.out.println("Connexió correcta");
            //Vista.vistaMainMenu(conn);
            String json = EldenRingApiClient.getWeaponsJson();
            System.out.println(json);

        } else {
            System.out.println("Error en la connexió");
        }
    }
}