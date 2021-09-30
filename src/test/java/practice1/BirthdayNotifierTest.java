package practice1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BirthdayNotifierTest {

    @Mock
    private BirthdayRepository birthdayRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private Sender sender;

    @Test
    void should_send_user_birthday_notification() throws Exception {
        when(birthdayRepository.upcomingBirthdays())
                .thenReturn(Arrays.asList("2000-11-01", "2000-11-02"));
        User firstBirthdayUser = new User("YY", "Male", "2000-11-01");
        User secondBirthdayUser = new User("DD", "Female", "2000-11-01");
        when(userRepository.findUser("2000-11-01"))
                .thenReturn(Arrays.asList(firstBirthdayUser, secondBirthdayUser));
        when(userRepository.findUser("2000-11-02")).thenReturn(Collections.emptyList());

        BirthdayNotifier notifier = new BirthdayNotifier(birthdayRepository, userRepository, sender);

        notifier.sendNotifications();

        verify(sender, times(1)).send(firstBirthdayUser);
        verify(sender,times(1)).send(firstBirthdayUser);
    }

    @Test
    void should_not_send_user_birthday_notification_when_no_upcoming_birthday() throws Exception {
        when(birthdayRepository.upcomingBirthdays()).thenReturn(Collections.emptyList());
        BirthdayNotifier notifier = new BirthdayNotifier(birthdayRepository, userRepository, sender);

        notifier.sendNotifications();

        verify(sender, never()).send(any());
    }

    @Test
    void should_not_send_user_birthday_notification_when_no_user_matched() throws Exception {
        when(birthdayRepository.upcomingBirthdays()).thenReturn(Collections.singletonList("2000-11-01"));
        when(userRepository.findUser("2000-11-01")).thenReturn(Collections.emptyList());

        BirthdayNotifier notifier = new BirthdayNotifier(birthdayRepository, userRepository, sender);

        notifier.sendNotifications();
        verify(sender, never()).send(any());
    }

    @Test
    void should_throw_exception_when_sender_has_error() throws Exception {
        when(birthdayRepository.upcomingBirthdays()).thenReturn(Collections.singletonList("2000-11-01"));
        User birthdayUser = new User("YY", "Male", "2000-11-01");
        when(userRepository.findUser("2000-11-01")).thenReturn(Collections.singletonList(birthdayUser));
        doThrow(new RuntimeException()).when(sender).send(any());
        doNothing().when(sender).recover();

        BirthdayNotifier notifier = new BirthdayNotifier(birthdayRepository, userRepository, sender);

        notifier.sendNotifications();

        verify(sender, times(1)).recover();
    }
}
