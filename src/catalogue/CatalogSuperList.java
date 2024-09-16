package catalogue;

public class CatalogSuperList extends ExtractList implements CatalogSuper {

    @Override
    public <T> void add(Class<? extends T> obj, T values) {
        put(obj, values);
    }

    @Override
    public void add(Object values) {
        add(values.getClass(), values);
    }

    @Override
    public <T> void addAll(Class<? extends T> obj, T... array) {
        for (T v : array) {
            add(obj, v);
        }
    }

    @Override
    public void addAll(Object... array) {
        for (Object obj : array){
            add(obj);
        }
    }

    @Override
    public void removeObject(Object values) {
        getListObject(values.getClass()).remove(values);
    }

    public CatalogSuperBlacklist setBlacklist() {
        CatalogSuperBlacklist blacklist = new CatalogSuperBlacklist();
        for (Class<?> obj : getObjectsClass()) {
            for (Object val : getObjects(obj)) {
                blacklist.add(obj, val);
            }
        }
        return blacklist;
    }

    public CatalogSuperBlacklist setBlacklist(Class<?>... c) {
        CatalogSuperBlacklist blacklist = setBlacklist();
        blacklist.blockAll(c);
        return blacklist;
    }

}
