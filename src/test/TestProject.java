package test;

import catalogue.CatalogBlacklist;
import catalogue.CatalogList;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class TestProject {

    public static void main(String[] args) throws MalformedURLException {
        System.out.println("===CatalogList===");
        CatalogList list = CatalogList.getInstance(1, 2, "str", new Date(), "Kotlin", new URL("https://github.com/AP-JavaCod/Catalogue_of_objects"), new Date(1788888));
        for (Class<?> c : list.getObjectsClass()) {
            System.out.println(c);
            for (Object o : list.getObjects(c)) {
                System.out.println(o);
            }
            System.out.println("---------------------------------------------------------------------------------");
        }
        System.out.println("===CatalogBlacklist===");
        CatalogBlacklist blacklist = list.setBlacklist(Integer.class, URL.class);
        for (Class<?> c : blacklist.getObjectsClass()){
            System.out.println(c);
            if (!blacklist.isBlacklist(c)){
                for (Object o : blacklist.getObjects(c)) {
                    System.out.println(o);
                }
            }else {
                System.out.println("ERROR: Blacklist");
            }
            System.out.println("---------------------------------------------------------------------------------");
        }
    }

}
