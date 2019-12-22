import database.Database;
import util.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws Exception {
        Database db = new Database();
        List<User> list = db.getAll();
        System.out.println(list);

        db.delete(7);
        list = db.getAll();
        System.out.println(list);

    }
}
