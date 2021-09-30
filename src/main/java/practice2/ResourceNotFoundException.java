package practice2;

public class ResourceNotFoundException extends Throwable {
    public ResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
