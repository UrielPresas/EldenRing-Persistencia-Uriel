package DAO;

import Model.Boss;

import java.sql.Connection;
import java.util.List;

public interface BossDAO extends DAO<Boss, String>{
    Boss obtenir(Connection conn, String id);
    List<Boss> obtenirTots(Connection conn);
}
