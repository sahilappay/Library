import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<User> userList = Database.getAllUser();
        System.out.println(userList);
}
}
