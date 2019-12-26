package abst;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDatabase {
    public static Connection connect() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mansys?serverTimezone=UTC";
        String username = "root";
        String password = "12345";

        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
