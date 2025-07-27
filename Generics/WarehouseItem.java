package Generics;

import java.util.*;

abstract class WarehouseItem{
    String name;
    WarehouseItem(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
}

class Electronics extends WarehouseItem {
    Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    Furniture(String name) {
        super(name);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    void addItem(T item) {
        items.add(item);
    }
    List<T> getItems() {
        return items;
    }
    static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
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
