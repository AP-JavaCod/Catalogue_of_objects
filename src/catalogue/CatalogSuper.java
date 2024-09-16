package catalogue;

public interface CatalogSuper extends Catalog{

    <T> void add(Class<? extends T> obj, T values);

    <T> void addAll(Class<? extends T> obj, T... array);

}
