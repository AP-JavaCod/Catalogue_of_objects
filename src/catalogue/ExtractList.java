package catalogue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtractList implements Extract {

    private final Map<Class<?>, List<Object>> data = new HashMap<>();

    protected final void put(Class<?> obj, Object values){
        if (!data.containsKey(obj)){
            data.put(obj, new ArrayList<>());
        }
        data.get(obj).add(values);
    }

    @Override
    public Class<?>[] getObjectsClass() {
        return data.keySet().toArray(new Class[0]);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] getObjects(Class<T> obj) {
        List<T> list = getListObject(obj);
        return list.toArray((T[]) Array.newInstance(obj, list.size()));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> obj, int index) {
        return (T) getListObject(obj).get(index);
    }

    @Override
    public void removeList(Class<?> obj) {
        data.remove(obj);
    }

    @Override
    public void removeObject(Class<?> obj, int index) {
        getListObject(obj).remove(index);
    }

    @SuppressWarnings("unchecked")
    protected <T> List<T> getListObject(Class<?> obj) {
        return (List<T>) data.get(obj);
    }

}
