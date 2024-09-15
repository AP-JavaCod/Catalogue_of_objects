package test;

import catalogue.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestProject {

    public static void main(String[] args) throws MalformedURLException {
        System.out.println("===CatalogList===");
        CatalogList list = CatalogList.getInstance(1, 2, "str", new Date(), "Kotlin", new URL("https://github.com/AP-JavaCod/Catalogue_of_objects"), new Date(1788888));
        print(list);

        System.out.println("===CatalogBlacklist===");
        CatalogBlacklist blacklist = list.setBlacklist(Integer.class, URL.class);
        print(blacklist);

        System.out.println("===CatalogSuperList===");
        CatalogSuperList superList = new CatalogSuperList();
        superList.add(Number.class, 12);
        superList.add(Number.class, 3.7);
        superList.add(Integer.class, 7);
        superList.add(List.class, Arrays.asList("Java", "C++", "cod"));
        superList.add(Object.class, new Date());
        superList.add(Object.class, "long");
        print(superList);

        System.out.println("===CatalogSuperBlacklist===");
        CatalogSuperBlacklist superBlacklist = superList.setBlacklist(Object.class, Double.class);
        print(superBlacklist);
    }

    public static void print(ExtractList data){
        for (ExtractList.DataValues d : data){
            System.out.println(d);
        }
    }

}
