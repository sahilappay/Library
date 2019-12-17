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

    public static List<User> getAllUser() throws Exception {
        List<User> userList = new ArrayList<>();
        try (Connection conn = connect()) {//chay
            Statement stmt = conn.createStatement();// qayiq
            stmt.execute("select * from user"); // get qayigi erzaqla doldur gel
            ResultSet rs = stmt.getResultSet(); // qayigin getirdiyi erzaq
            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");
                userList.add(new User(name, id));
            }
            return userList;
        }
    }

    public static List<User> getAllUserByPS() throws Exception {
        List<User> userList = new ArrayList<>();
        try (Connection conn = connect()) {
            PreparedStatement stmt = conn.prepareStatement("select * from user");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");
                userList.add(new User(name, id));
            }
            return userList;
        }
    }

    public static boolean update(User user) throws Exception {
        try (Connection conn = connect()) {
            PreparedStatement stmt = conn.prepareStatement("update user set name=? where  id =?");//
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getId());
            stmt.executeUpdate();
        }
        return true;
    }

    public static int insert(User user) throws Exception {
        try (Connection conn = connect()) {
            PreparedStatement stmt = conn.prepareStatement("insert into student (name, surname) values (?,?)");//
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            return stmt.executeUpdate();
        }
    }

    public static int delete(int id) throws Exception {
        try (Connection conn = connect()) {
            PreparedStatement stmt = conn.prepareStatement("delete from student where id =?");//
            stmt.setInt(1,id);
            return stmt.executeUpdate();
        }
    }


}
