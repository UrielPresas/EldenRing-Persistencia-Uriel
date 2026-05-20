import API.AshImporter;
import API.BossImporter;
import API.EldenRingApiClient;
import API.DTO.WeaponResponse;
import API.WeaponImporter;
import com.google.gson.Gson;
import DAO.Connexions.ConexioFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//import Vista.Vista;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Escull base de dades (mysql/postgres): ");
        String opcio = sc.nextLine();

        Connection conn = ConexioFactory.getConnection(opcio);
        try {
            conn.setAutoCommit(false);

            WeaponImporter.importar(conn);
            BossImporter.importar(conn);
            AshImporter.importar(conn);

            conn.commit();

            System.out.println("Importació completada");
        } catch (Exception e) {
            conn.rollback();
            System.out.println("Rollback executat");
            e.printStackTrace();
        }

        if(conn != null){
            System.out.println("Connexió correcta");
            String json = EldenRingApiClient.getWeaponsJson();
            Gson gson = new Gson();
            WeaponResponse response =
                    gson.fromJson(json, WeaponResponse.class);

        } else {
            System.out.println("Error en la connexió");
        }
    }
}