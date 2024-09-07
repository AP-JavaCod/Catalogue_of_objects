package catalogue;

public interface Blacklist {

    void block(Class<?> obj);

    void blockAll(Class<?> ...obj);

    void unblock(Class<?> obj);

    boolean isBlacklist(Class<?> obj);

    Class<?>[] getBlocks();

    default void error(Class<?> obj) {
        if (isBlacklist(obj)) {
            throw new BlacklistException(obj);
        }
    }

}
