package catalogue;

public class BlacklistException extends RuntimeException {

    public BlacklistException(Class<?> obj) {
        super(obj + " on blacklist");
    }

}
