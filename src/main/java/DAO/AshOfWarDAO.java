package DAO;

import Model.AshOfWar;

import java.sql.Connection;
import java.util.List;

public interface AshOfWarDAO extends DAO<AshOfWar, String>{
    AshOfWar obtenir(Connection conn, String id);

    List<AshOfWar> obtenirTots(Connection conn);
}
