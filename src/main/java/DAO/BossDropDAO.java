package DAO;

import Model.BossDrop;

import java.sql.Connection;
import java.util.List;

public interface BossDropDAO extends DAO<BossDrop, Integer> {
    List<BossDrop> findByBossId(Connection conn, String id);
}
