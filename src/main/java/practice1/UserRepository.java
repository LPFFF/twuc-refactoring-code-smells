package practice1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    public List<User> findUser(String birthday) {
        List<User> users = Arrays.asList(
                new User("YY", "Male", "1990-11-01"),
                new User("WY", "Female", "1990-11-01"),
                new User("TJY", "Female", "1990-11-01")
        );

        return users.stream()
                .filter(user -> birthday.equals(user.getBirthday()))
                .collect(Collectors.toList());
    }
}
