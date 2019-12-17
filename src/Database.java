import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public static Connection connect() throws Exception{

        Class.forName("com.mysql.jdbc.Driver");// Classi load edir

        String  url = "jdbc:mysql://localhost:3306/filemansys?serverTimezone=UTC";
        String username = "root";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static List<User> getAllUser() throws Exception{
        List<User> userList = new ArrayList<>();

        Connection conn = connect();//chay
        Statement stmt = conn.createStatement();// qayiq
        stmt.execute("select * from user"); // get qayigi erzaqla doldur gel

        ResultSet rs = stmt.getResultSet(); // qayigin getirdiyi erzaq
        while (rs.next()){

            String name = rs.getString("name");
            int id = rs.getInt("id");
            userList.add(new User(name, id));
        }

        return userList;
    }

}
