package database;

import abst.AbstractDatabase;
import inter.IDatabase;
import util.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database extends AbstractDatabase implements IDatabase<User> {

    @Override
    public  List<User> getAll() throws Exception {
        List<User> result = new ArrayList<>();
        try(Connection conn = connect();){
            Statement stmt = conn.createStatement();
            stmt.execute("select * from  student");

            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                result.add(new User(name, surname, age));
            }
        }
        return result;
    }

    @Override
    public  List<User> getAllByPS() throws Exception {
        List<User> result = new ArrayList<>();
        try(Connection conn = connect();){
            PreparedStatement stmt = conn.prepareStatement("select * from  student");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                result.add(new User(name, surname, age));
            }
        }
        return result;
    }

    @Override
    public  int update(User user) throws Exception{
        try(Connection conn = connect();) {
            PreparedStatement stmt = conn.prepareStatement("update student set name=? where id=?");
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getId());
            return stmt.executeUpdate();
        }
    }

    @Override
    public  int insert(User user) throws Exception{
        try(Connection conn = connect();) {
            PreparedStatement stmt = conn.prepareStatement("insert into student (name , surname , age) values (?,?,?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            stmt.setInt(3, user.getAge());
            return stmt.executeUpdate();
        }
    }

    @Override
    public  int delete(int id) throws Exception{
        try(Connection conn = connect();) {
            PreparedStatement stmt = conn.prepareStatement("delete from student where id =?");
            stmt.setInt(1 , id);
            return stmt.executeUpdate();
        }
    }
}