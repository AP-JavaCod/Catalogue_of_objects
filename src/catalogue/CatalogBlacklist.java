package catalogue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CatalogBlacklist extends CatalogList implements Blacklist {

    private final BlacklistSet blacklist = new BlacklistSet();

    @Override
    public void block(Class<?> obj) {
        blacklist.block(obj);
    }

    @Override
    public void blockAll(Class<?>... obj) {
        blacklist.blockAll(obj);
    }

    @Override
    public void unblock(Class<?> obj) {
        blacklist.unblock(obj);
    }

    @Override
    public boolean isBlacklist(Class<?> obj) {
        return blacklist.isBlacklist(obj);
    }

    @Override
    public Class<?>[] getBlocks() {
        return blacklist.getBlocks();
    }

    @Override
    public void add(Object values) {
        error(values.getClass());
        super.add(values);
    }

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

    @Override
    public Iterator<DataValues> iterator() {
        Set<Class<?>> notBlacklist = new HashSet<>();
        for (Class<?> obj : getObjectsClass()){
            if (!isBlacklist(obj)){
                notBlacklist.add(obj);
            }
        }
        return new DataIterator(notBlacklist.toArray(new Class[0]));
    }
}
