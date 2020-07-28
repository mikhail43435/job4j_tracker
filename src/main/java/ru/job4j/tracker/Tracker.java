package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;
    private int length;

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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    /**
     * возвращает копию массива items без null элементов (без пустых ячеек)
     */
    public Item[] findAll(Item[] items) {
        return Arrays.copyOf(items, size);
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

    /**
     * метод выводит в консоль все содержимое трекера
     */
    public void printAllTracker(Tracker tracker) {
        System.out.println("======= Printing all tracker");
        for (int index = 0; index < tracker.size; index++) {
            System.out.println("Item № " + (index + 1)
                    + "     item name: " + this.items[index].getName()
                    + "   item id: " + this.items[index].getId());
        }
    }

    /**
     *  метод, который будет возвращать index по id
     */
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < this.size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    /**
     * метод замены заявки.
     * удаляем заявку, которая уже есть в системе
     * и добавляем в эту ячейку новую.
     */
    public Boolean replace(int id, Item item) {
        boolean rsl = false;
        int indexFound = this.indexOf(id);
        if (indexFound != -1) {
            this.items[indexFound].setName(item.getName());
            rsl = true;
        } else {
            System.out.println("Заявка для замены с индексом [" + id + "] не найдена");
        }
        return rsl;
    }
}