package DAO.MySQL;

import DAO.Connexions.ConexioFactory;
import DAO.WeaponDAO;
import Model.Weapon;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySQLWeaponDAO implements WeaponDAO {

    @Override
    public void inserir(Connection conn, Weapon obj, boolean overwrite) {

        String sql = "";

        if(overwrite) {
            sql = """
                    INSERT INTO weapons (id_weapon, name, img, description, category, weight)
                        VALUES (?, ?, ?, ?, ?, ?)
                        ON DUPLICATE KEY UPDATE
                            name = VALUES(name),
                            img = VALUES(img),
                            description = VALUES(description),
                            category = VALUES(category),
                            weight = VALUES(weight)
                    """;
        }else{ //INSERT IGNORE, basicament ignora els camps que tenen el mateix id llavors es pot fer la copia parcial, mentres que amb el ON KYE UPDATE fa una copia completa
            sql = """
                INSERT IGNORE INTO weapons
                (id_weapon, name, img, description, category, weight)
                    VALUES (?, ?, ?, ?, ?, ?)
                """;
        }

        try(PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, obj.getId_weapon());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getImg());
            ps.setString(4, obj.getDescription());
            ps.setString(5, obj.getCategory());
            ps.setDouble(6, obj.getWeight());

            ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void inserir(Connection conn, Weapon obj) {

    }

    @Override
    public void modificar(Connection conn, Weapon obj) {

        String sql = """
            UPDATE weapons
                SET name = ?,
                    img = ?,
                    description = ?,
                    category = ?,
                    weight = ?,
                    last_update = CURRENT_TIMESTAMP
            WHERE id_weapon = ?
            """;

        try(PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, obj.getName());
            ps.setString(2, obj.getImg());
            ps.setString(3, obj.getDescription());
            ps.setString(4, obj.getCategory());
            ps.setDouble(5, obj.getWeight());
            ps.setString(6, obj.getId_weapon());

            ps.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Connection conn, Weapon obj) {

    }

    @Override
    public Weapon obtenir(Connection conn, Weapon obj) {
        return null;
    }

    @Override
    public Weapon obtenir(Connection conn, String id) {

        String sql = """
            SELECT *
                FROM weapons
            WHERE id_weapon = ?
            """;

        try(PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Weapon weapon = new Weapon();

                weapon.setId_weapon(
                        rs.getString("id_weapon")
                );

                weapon.setName(
                        rs.getString("name")
                );

                weapon.setImg(
                        rs.getString("img")
                );

                weapon.setDescription(
                        rs.getString("description")
                );

                weapon.setCategory(
                        rs.getString("category")
                );

                weapon.setWeight(
                        rs.getDouble("weight")
                );

                return weapon;
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Weapon> obtenirTots(Connection conn) {

        String sql = """
            SELECT *
                FROM weapons
            ORDER BY name
        """;

        List<Weapon> weapons = new ArrayList<>();

        try(PreparedStatement ps =
                    conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Weapon w = new Weapon();

                w.setId_weapon(
                        rs.getString("id_weapon")
                );

                w.setName(
                        rs.getString("name")
                );

                weapons.add(w);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return weapons;
    }

    @Override
    public List<Weapon> obtenirTots() {

        String sql = """
                SELECT *
                    FROM weapons
                """;

        List<Weapon> wList = new ArrayList<>();

        try(Connection conn = ConexioFactory.getConnection("mysql");
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()){

                Weapon w = new Weapon();

                w.setId_weapon(rs.getString("id_weapon"));
                w.setName(rs.getString("name"));
                w.setImg(rs.getString("img"));
                w.setDescription(rs.getString("description"));
                w.setCategory(rs.getString("category"));
                w.setWeight(rs.getDouble("weight"));

                wList.add(w);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return wList;
    }

}
