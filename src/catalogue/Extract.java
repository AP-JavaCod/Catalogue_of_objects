package catalogue;

public interface Extract {

    Class<?>[] getObjectsClass();

    <T> T[] getObjects(Class<T> obj);

    <T> T getObject(Class<T> obj, int index);

    void removeList(Class<?> obj);

    void removeObject(Class<?> obj, int index);

}
