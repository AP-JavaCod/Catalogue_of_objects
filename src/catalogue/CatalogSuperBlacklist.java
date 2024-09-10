package catalogue;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CatalogSuperBlacklist extends CatalogSuperList implements Blacklist{

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
    public <T> void add(Class<? extends T> obj, T values) {
        error(obj);
        super.add(obj, values);
    }

    @Override
    public void removeObjectsBlacklist() {
        for (Class<?> obj : blacklist){
            removeList(obj);
        }
    }

    @Override
    protected <T> List<T> getListObject(Class<?> obj) {
        error(obj);
        return super.getListObject(obj);
    }
}
