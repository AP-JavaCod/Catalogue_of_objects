package catalogue;

import java.lang.reflect.Array;
import java.util.*;

public class ExtractList implements Extract, Iterable<ExtractList.DataValues> {

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

    @Override
    public Iterator<DataValues> iterator() {
        return new DataIterator(getObjectsClass());
    }

    protected class DataIterator implements Iterator<DataValues> {

        protected final Class<?>[] classes;
        protected Object[] objects;
        protected int indexClass = 0;
        protected int indexObject = 0;

        public DataIterator(Class<?>[] classes){
            this.classes = classes;
            objects = getObjects(this.classes[indexClass]);
            indexClass++;
        }

        @Override
        public boolean hasNext() {
            return objects.length > indexObject || classes.length > indexClass;
        }

        @Override
        public DataValues next() {
            DataValues val;
            if (objects.length > indexObject) {
                val = new DataValues(classes[indexClass - 1], objects[indexObject]);
                indexObject++;
            }else if (classes.length > indexClass){
                objects = getObjects(classes[indexClass]);
                indexClass++;
                indexObject = 0;
                if (objects.length > 0){
                    val = new DataValues(classes[indexClass - 1], objects[indexObject]);
                    indexObject++;
                }else {
                    val = new DataValues(classes[indexClass - 1], null);
                }
            }else {
                throw new NullPointerException();
            }
            return val;
        }
    }

    public class DataValues{

        private final Class<?> classData;
        private final Object data;

        private DataValues(Class<?> classData, Object data){
            this.classData = classData;
            this.data = data;
        }

        @Override
        public String toString() {
            return classData + " : " + data;
        }

        public Class<?> getClassData() {
            return classData;
        }

        public Object getData() {
            return data;
        }

    }

}
