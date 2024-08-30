package catalogue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogList implements Catalog{

    private final Map<Class<Object>, List<Object>> data = new HashMap<>();

    @Override
    public void add(Object values) {
        Class<Object> obj = (Class<Object>) values.getClass();
        if (!data.containsKey(obj)){
           data.put(obj, new ArrayList<>());
        }
        data.get(obj).add(values);
    }

    @Override
    public <T> List<T> getListObject(Class<T> obj) {
        return (List<T>) data.get(obj);
    }

    @Override
    public <T> T getObject(Class<T> obj, int index) {
        return getListObject(obj).get(index);
    }

    @Override
    public <T> void removeList(Class<T> obj) {
        data.remove(obj);
    }

    @Override
    public <T> void removeObject(Class<T> obj, int index) {
        getListObject(obj).remove(index);
    }

    @Override
    public void removeObject(Object values) {
        getListObject(values.getClass()).remove(values);
    }
}
