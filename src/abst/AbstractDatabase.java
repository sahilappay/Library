package abst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public abstract class AbstractDatabase<T> {
    protected static Connection connect() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");// Classi load edir
        String  url = "jdbc:mysql://localhost:3306/filemansys?serverTimezone=UTC";
        String username = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public abstract List<T> getAll() throws Exception ;

    public abstract List<T> getAllByPS() throws Exception;

    public abstract boolean update(T obj) throws Exception;

    public abstract int insert(T obj) throws Exception;

    public abstract int delete(int id) throws Exception;
}
