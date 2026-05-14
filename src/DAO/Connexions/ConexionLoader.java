package DAO.Connexions;

import java.util.Properties;
import java.io.FileInputStream;

public class ConexionLoader {

    public static Properties load() {
        Properties props = new Properties();

        try {
            FileInputStream fis = new FileInputStream("src/configBD/dataBase.properties");
            props.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return props;
    }
}