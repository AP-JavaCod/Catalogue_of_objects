package catalogue;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CatalogBlacklist extends CatalogList implements Blacklist{

    private final Set<Class<Objects>> blacklist = new HashSet<>();

    @Override
    public <T> void block(Class<T> obj) {
        blacklist.add((Class<Objects>) obj);
    }

    @Override
    public <T> void unblock(Class<T> obj) {
        blacklist.remove(obj);
    }

    @Override
    public <T> boolean isBlacklist(Class<T> obj) {
        return blacklist.contains(obj);
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

    public void removeObjectsBlacklist(){
        for (Class<Objects> obj : blacklist){
            removeList(obj);
        }
    }

}
