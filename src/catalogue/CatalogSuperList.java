package catalogue;

import java.util.ArrayList;
import java.util.Collections;

public class CatalogSuperList extends ExtractList implements CatalogSuper {

    @Override
    public <T> void add(Class<? extends T> obj, T values) {
        if (!data.containsKey(obj)) {
            data.put(obj, new ArrayList<>());
        }
        data.get(obj).add(values);
    }

    @Override
    public <T> void addAll(Class<? extends T> obj, T... array) {
        if (!data.containsKey(obj)) {
            data.put(obj, new ArrayList<>());
        }
        Collections.addAll(data.get(obj), array);
    }

    public CatalogSuperBlacklist setBlacklist() {
        CatalogSuperBlacklist blacklist = new CatalogSuperBlacklist();
        for (Class<?> obj : data.keySet()) {
            for (Object val : data.get(obj)) {
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
