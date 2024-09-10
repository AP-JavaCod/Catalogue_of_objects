package catalogue;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BlacklistSet implements Blacklist {

    private final Set<Class<?>> blacklist = new HashSet<>();

    @Override
    public void block(Class<?> obj) {
        blacklist.add(obj);
    }

    @Override
    public void blockAll(Class<?>... obj) {
        Collections.addAll(blacklist, obj);
    }

    @Override
    public void unblock(Class<?> obj) {
        blacklist.remove(obj);
    }

    @Override
    public boolean isBlacklist(Class<?> obj) {
        return blacklist.contains(obj);
    }

    @Override
    public Class<?>[] getBlocks() {
        return blacklist.toArray(new Class[0]);
    }

    @Override
    public abstract void removeObjectsBlacklist();

}
