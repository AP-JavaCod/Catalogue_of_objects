package catalogue;

import java.util.List;

public interface Catalog {

    void add(Object values);
    <T> List<T> getListObject(Class<T> obj);
    <T> T getObject(Class<T> obj, int index);
    <T> void removeList(Class<T> obj);
    <T> void removeObject(Class<T> obj, int index);

}
