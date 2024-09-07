package catalogue;

import java.util.List;

public interface Catalog {

    void add(Object values);

    void add(Object[] array);

    <T> List<T> getListObject(Class<T> obj);

    <T> T[] getObjects(Class<T> tClass);

    <T> T getObject(Class<T> obj, int index);

    void removeList(Class<?> obj);

    void removeObject(Class<?> obj, int index);

    void removeObject(Object values);

}
