package catalogue;

import java.lang.reflect.Array;
import java.util.*;

public class CatalogSuperList implements CatalogSuper {

    private final Map<Class<?>, List<Object>> data = new HashMap<>();

    @Override
    public <T> void add(Class<T> obj, T values) {
        if (!data.containsKey(obj)){
            data.put(obj, new ArrayList<>());
        }
        data.get(obj).add(values);
    }

    @Override
    public <T> void addAll(Class<T> obj, T... array) {
        if (!data.containsKey(obj)){
            data.put(obj, new ArrayList<>());
        }
        Collections.addAll(data.get(obj), array);
    }

    @Override
    public Class<?>[] getObjectsClass() {
        return data.keySet().toArray(new Class[0]);
    }

    @Override
    public <T> T[] getObjects(Class<T> obj) {
        List<T> list = (List<T>) data.get(obj);
        return list.toArray((T[])Array.newInstance(obj, list.size()));
    }

    @Override
    public <T> T getObject(Class<T> obj, int index) {
        return (T) data.get(obj).get(index);
    }

    @Override
    public void removeList(Class<?> obj) {
        data.remove(obj);
    }

    @Override
    public void removeObject(Class<?> obj, int index) {
        data.get(obj).remove(index);
    }
}
