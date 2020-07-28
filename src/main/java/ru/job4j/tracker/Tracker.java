package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**
     * метод добавляет заявку, переданную в аргументах в массив заявок items
     * поле ids используется для генерации нового ключа
     * в нашем примере мы используем последовательность
     * то есть каждый вызов метод add будет добавлять в поле ids единицу
     * так мы сможем обеспечить уникальность поле id в Item
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * проверяет в цикле все элементы массива items,
     * сравнивая id с аргументом int id
     * и возвращает найденный Item.
     * Если Item не найден - возвращает null.
     */
    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    /**
     * возвращает копию массива items без null элементов (без пустых ячеек)
     */
    public Item[] findAll(Item[] items) {
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item.getName() != null) {
                itemsWithoutNull[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, size);
    }

    /**
     * проверяет в цикле все элементы массива items,
     * сравнивая name (используя метод getName класса Item)
     * с аргументом метода String key. Элементы, у которых совпадает name,
     * копирует в результирующий массив и возвращает его.
     * алгоритм этого метода аналогичен методу findAll
     */
    public Item[] findByName(String key) {
        Item[] itemsWithSameName = new Item[items.length];
        int size = 0;
        for (int index = 0; index < this.size; index++) {
            //String itemName = item[index].getName();
            if (items[index].getName().equals(key)) {
                itemsWithSameName[size] = items[index];
                size++;
            }
        }
        itemsWithSameName = Arrays.copyOf(itemsWithSameName, size);
        return itemsWithSameName;
    }

    /**
     * метод выводит в консоль переданный объект item
     */
    public void printItem(Item item) {
        if (item != null) {
            System.out.println("Item name: " + item.getName() + "   item id: " + item.getId());
        } else
            System.out.println("Can't print null object!");
    }

    /**
     * метод выводит в консоль переданный объект массив items
     */
    public void printItems(Item[] items) {
        if (items != null) {
            System.out.println("======= Printing items array");
            for (int index = 0; index < items.length; index++) {
                System.out.println("Item № " + (index + 1) + "     item name: " + items[index].getName() + "   item id: " + items[index].getId());
            }
        } else
            System.out.println("Can't print null object!");
    }
}