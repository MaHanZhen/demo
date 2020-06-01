package characteristic;

import java.util.ArrayList;
import java.util.List;

/**
 * Stream流特性
 */
public class StreamCharacteristic {


    private List<User> createUserList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            Integer random = Integer.parseInt(String.valueOf(Math.random() * 100));
            user.setAge(random);
            user.setSex(random % 2);
            user.setName("name" + i);
            users.add(user);
        }

        return users;
    }
}
