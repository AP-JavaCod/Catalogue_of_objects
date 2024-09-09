package catalogue;

import java.util.*;

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

}
