package practice1;

public class Sender {
    public void send(User user) throws Exception {
        throw new Exception("send");
    }

    public void recover() {
        System.out.println("recover");
    }
}
