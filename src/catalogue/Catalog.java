package catalogue;

public interface Catalog {

    void add(Object values);

    void add(Object[] array);

    Class<?>[] getObjectsClass();

    <T> T[] getObjects(Class<T> tClass);

    <T> T getObject(Class<T> obj, int index);

    void removeList(Class<?> obj);

    void removeObject(Class<?> obj, int index);

    void removeObject(Object values);

}
