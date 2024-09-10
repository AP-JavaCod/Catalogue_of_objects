package catalogue;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtractList implements Extract {

    protected final Map<Class<?>, List<Object>> data = new HashMap<>();

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
