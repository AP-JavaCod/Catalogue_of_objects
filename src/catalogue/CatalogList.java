package catalogue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogList implements Catalog {

    private final Map<Class<?>, List<Object>> data = new HashMap<>();

    @Override
    public void add(Object values) {
        Class<?> obj = values.getClass();
        if (!data.containsKey(obj)) {
            data.put(obj, new ArrayList<>());
        }
        data.get(obj).add(values);
    }

    @Override
    public void addAll(Object ...array) {
        for (Object val : array) {
            add(val);
        }
    }

    @Override
    public Class<?>[] getObjectsClass() {
        return data.keySet().toArray(new Class[0]);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] getObjects(Class<T> tClass) {
        List<T> list = getListObject(tClass);
        return list.toArray((T[]) Array.newInstance(tClass, list.size()));
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

    @Override
    public void removeObject(Object values) {
        getListObject(values.getClass()).remove(values);
    }

    public static CatalogList getInstance(Object ...data){
        CatalogList list = new CatalogList();
        list.add(data);
        return list;
    }

    @SuppressWarnings("unchecked")
    protected <T> List<T> getListObject(Class<?> obj){
        return (List<T>) data.get(obj);
    }

    public CatalogBlacklist setBlacklist() {
        CatalogBlacklist blacklist = new CatalogBlacklist();
        for (Class<?> obj : data.keySet()) {
            for (Object val : data.get(obj)) {
                blacklist.add(val);
            }
        }
        return blacklist;
    }

    public CatalogBlacklist setBlacklist(Class<?> c){
        CatalogBlacklist blacklist = setBlacklist();
        blacklist.blockAll(c);
        return blacklist;
    }

}
