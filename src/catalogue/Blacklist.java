package catalogue;

public interface Blacklist {

    <T> void block(Class<T> obj);
    <T> void unblock(Class<T> obj);
    <T> boolean isBlacklist(Class<T> obj);

    default <T> void error(Class<T> obj){
        if (isBlacklist(obj)){
            throw new BlacklistException(obj);
        }
    }

}
