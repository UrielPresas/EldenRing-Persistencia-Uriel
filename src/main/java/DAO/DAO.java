package DAO;

import java.sql.Connection;
import java.util.List;

// T == Tipus d'objecte (Candidat, Via, Sector...)
// K == Tipus de clau primaria (Long, String, int, Float...)
public interface DAO<T, ID> {
    void inserir(Connection conn, T obj);
    void modificar(Connection conn, T obj);
    void eliminar(Connection conn, T obj);
    T obtenir(Connection conn, T obj);
    List<T> obtenirTots();
}
