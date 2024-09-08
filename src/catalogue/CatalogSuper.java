package catalogue;

public interface CatalogSuper {

    <T> void add(Class<T> obj, T values);

    <T> void addAll(Class<T> obj, T ...array);

    Class<?>[] getObjectsClass();

    <T> T[] getObjects(Class<T> obj);

    <T> T getObject(Class<T> obj, int index);

    void removeList(Class<?> obj);

    void  removeObject(Class<?> obj, int index);
}
