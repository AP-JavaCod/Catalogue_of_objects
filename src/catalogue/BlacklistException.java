package catalogue;

public class BlacklistException extends RuntimeException {

    public <T> BlacklistException(Class<T> obj) {
        super(obj + " on blacklist");
    }

}
