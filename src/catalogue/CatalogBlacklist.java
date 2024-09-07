package catalogue;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CatalogBlacklist extends CatalogList implements Blacklist {

    private final Set<Class<?>> blacklist = new HashSet<>();

    public CatalogBlacklist(){

    }

    public CatalogBlacklist(Class<?> ...array){
        Collections.addAll(blacklist, array);
    }

    @Override
    public void block(Class<?> obj) {
        blacklist.add(obj);
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
    public void add(Object values) {
        error(values.getClass());
        super.add(values);
    }

    @Override
    public <T> List<T> getListObject(Class<T> obj) {
        error(obj);
        return super.getListObject(obj);
    }

    public void removeObjectsBlacklist() {
        for (Class<?> obj : blacklist) {
            removeList(obj);
        }
    }

}
