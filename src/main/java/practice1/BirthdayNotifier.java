package practice1;

import java.util.List;

public class BirthdayNotifier {
    private final BirthdayRepository birthdayRepository;
    private final UserRepository userRepository;
    private final Sender sender;

    public BirthdayNotifier(BirthdayRepository birthdayRepository, UserRepository userRepository, Sender sender) {
        this.birthdayRepository = birthdayRepository;
        this.userRepository = userRepository;
        this.sender = sender;
    }

    public void sendNotifications() {
        List<String> birthdays = birthdayRepository.upcomingBirthdays();

        birthdays.forEach(birthday -> userRepository.findUser(birthday).forEach(this::sendSmsMessage));
    }

    private void sendSmsMessage(User user) {
        try {
            sender.send(user);
        } catch (Exception e) {
            sender.recover();
        }
    }
}
