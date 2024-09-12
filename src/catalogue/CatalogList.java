package catalogue;

public class CatalogList extends ExtractList implements Catalog {

    @Override
    public void add(Object values) {
        put(values.getClass(), values);
    }

    @Override
    public void addAll(Object... array) {
        for (Object val : array) {
            add(val);
        }
    }

    @Override
    public void removeObject(Object values) {
        getListObject(values.getClass()).remove(values);
    }

    public static CatalogList getInstance(Object... data) {
        CatalogList list = new CatalogList();
        list.addAll(data);
        return list;
    }

    public CatalogBlacklist setBlacklist() {
        CatalogBlacklist blacklist = new CatalogBlacklist();
        for (Class<?> obj : getObjectsClass()) {
            for (Object val : getObjects(obj)) {
                blacklist.add(val);
            }
        }
        return blacklist;
    }

    public CatalogBlacklist setBlacklist(Class<?>... c) {
        CatalogBlacklist blacklist = setBlacklist();
        blacklist.blockAll(c);
        return blacklist;
    }

}
