package catalogue;

public interface Blacklist {

    <T> void block(Class<T> obj);
    <T> void unblock(Class<T> obj);
    <T> boolean isBlacklist(Class<T> obj);

}
