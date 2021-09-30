package practice3;

public class ResourceNotFoundException extends Throwable {
    public ResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
