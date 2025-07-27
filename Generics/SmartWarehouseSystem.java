package Generics;

import java.util.*;

abstract class SmartWarehouseItem{
    String name;
    SmartWarehouseItem(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
}

class Electronics extends SmartWarehouseItem {
    Electronics(String name) {
        super(name);
    }
}

class Groceries extends SmartWarehouseItem {
    Groceries(String name) {
        super(name);
    }
}

class Furniture extends SmartWarehouseItem {
    Furniture(String name) {
        super(name);
    }
}

class Storage<T extends SmartWarehouseItem> {
    private List<T> items = new ArrayList<>();
    void addItem(T item) {
        items.add(item);
    }
    List<T> getItems() {
        return items;
    }
    static void displayItems(List<? extends SmartWarehouseItem> items) {
        for (SmartWarehouseItem item : items) {
            System.out.println(item.getName());
        }
    }
}

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics(sc.nextLine()));
        Storage.displayItems(electronicsStorage.getItems());
        sc.close();
    }
}
