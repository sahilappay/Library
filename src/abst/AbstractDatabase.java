package abst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public abstract class AbstractDatabase {
    protected static Connection connect() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");// Classi load edir
        String  url = "jdbc:mysql://localhost:3306/filemansys?serverTimezone=UTC";
        String username = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

}
