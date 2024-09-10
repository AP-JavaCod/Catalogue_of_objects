package catalogue;

import java.util.List;

public class CatalogBlacklist extends CatalogList implements Blacklist {

    private final BlacklistSet blacklist = new BlacklistSet() {
        @Override
        public void removeObjectsBlacklist() {
            for (Class<?> obj : getBlocks()){
                removeList(obj);
            }
        }
    };

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

    @Override
    public void removeObjectsBlacklist() {
        blacklist.removeObjectsBlacklist();
    }

    @Override
    protected <T> List<T> getListObject(Class<?> obj) {
        error(obj);
        return super.getListObject(obj);
    }
}
