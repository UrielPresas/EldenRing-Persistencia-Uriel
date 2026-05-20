import API.BossImporter;
import API.EldenRingApiClient;
import API.DTO.WeaponResponse;
import API.WeaponImporter;
import com.google.gson.Gson;
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
            Gson gson = new Gson();
            WeaponResponse response =
                    gson.fromJson(json, WeaponResponse.class);

            //System.out.println(response.getData().size());
            //System.out.println(response.getData().get(70).getName());

            //WeaponImporter.importar();
            BossImporter.importar();

        } else {
            System.out.println("Error en la connexió");
        }
    }
}