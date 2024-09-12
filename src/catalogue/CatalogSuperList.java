package catalogue;

public class CatalogSuperList extends ExtractList implements CatalogSuper {

    @Override
    public <T> void add(Class<? extends T> obj, T values) {
        put(obj, values);
    }

    @Override
    public <T> void addAll(Class<? extends T> obj, T... array) {
        for (T v : array) {
            add(obj, v);
        }
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
