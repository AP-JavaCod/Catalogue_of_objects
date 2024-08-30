package catalogue;

public class BlacklistException extends RuntimeException {

    public BlacklistException(Class<Object> obj) {
        super(obj + " on blacklist");
    }

}
