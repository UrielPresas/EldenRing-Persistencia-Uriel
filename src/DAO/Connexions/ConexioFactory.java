package DAO.Connexions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexioFactory {

    public static Connection getConnectionMySQL(){
        Properties prop = ConexionLoader.load();

        String url = prop.getProperty("db.mysql.url");
        String user = prop.getProperty("db.mysql.user");
        String pass = prop.getProperty("db.mysql.pass");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getConnectionPostgres(){
        Properties prop = ConexionLoader.load();

        String url = prop.getProperty("db.postgres.url");
        String user = prop.getProperty("db.postgres.user");
        String pass = prop.getProperty("db.postgres.pass");

        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getConnection(String tipus){
        if(tipus.equalsIgnoreCase("mysql")){
            return getConnectionMySQL();
        } else if(tipus.equalsIgnoreCase("postgres")){
            return getConnectionPostgres();
        } else {
            System.out.println("Tipus de base de dades no vàlid");
            return null;
        }
    }


}