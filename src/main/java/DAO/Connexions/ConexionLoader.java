package DAO.Connexions;

import java.io.InputStream;
import java.util.Properties;

public class ConexionLoader {

    public static Properties load() {
        Properties props = new Properties();

        try {
            InputStream is = ConexionLoader.class
                    .getClassLoader()
                    .getResourceAsStream("configBD/dataBase.properties");

            props.load(is);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return props;
    }
}