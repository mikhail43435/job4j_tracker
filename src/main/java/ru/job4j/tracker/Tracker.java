package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Collections;

public class Tracker {
    //private final Item[] items = new Item[100];
    private final ArrayList <Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;
    //private int length;

    /**
     * метод добавляет заявку, переданную в аргументах в массив заявок items
     * поле ids используется для генерации нового ключа
     * в нашем примере мы используем последовательность
     * то есть каждый вызов метод add будет добавлять в поле ids единицу
     * так мы сможем обеспечить уникальность поле id в Item
     */
    public Item add(Item item) {
        item.setId(ids++);
        //items[size++] = item;
        items.add(item);
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
        //return index != -1 ? items[index] : null;
        return index != -1 ? items.get(index) : null;
    }

    /**
     * возвращает копию массива items без null элементов (без пустых ячеек)
     */
    public ArrayList<Item> findAll() {
        //return Arrays.copyOf(items, size);
        return this.items;
    }

    /**
     * возвращает копию массива items без null элементов (без пустых ячеек)
     */
    /*public Item[] findAll() {
        return Arrays.copyOf(this.items, this.size);
    }*/

    /**
     * возвращает копию массива items без null элементов (без пустых ячеек)
     */
/*    public Item[] findAllItemsInTracker(Tracker tracker) {
        return Arrays.copyOf(tracker.items, tracker.size);
    }*/

    /**
     * проверяет в цикле все элементы массива items,
     * сравнивая name (используя метод getName класса Item)
     * с аргументом метода String key. Элементы, у которых совпадает name,
     * копирует в результирующий массив и возвращает его.
     * алгоритм этого метода аналогичен методу findAll
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> itemsWithSameName = new ArrayList<>();
        for (Item value : items) {
            //String itemName = item[index].getName();
            if (value.getName().equals(key)) {
                itemsWithSameName.add(value);
            }
        }
        return itemsWithSameName;
/*        Item[] itemsWithSameName = new Item[items.length];
        int size = 0;
        for (int index = 0; index < this.size; index++) {
            //String itemName = item[index].getName();
            if (items[index].getName().equals(key)) {
                itemsWithSameName[size] = items[index];
                size++;
            }
        }
        itemsWithSameName = Arrays.copyOf(itemsWithSameName, size);
        return itemsWithSameName;*/
    }


    /**
     * метод, который будет возвращать index по id
     */
    private int indexOf(int id) {
        int rsl = -1;
        int index = 0;
        //for (int index = 0; index < this.size; index++) {
        for (Item value : this.items) {// int index = 0; index < this.size; index++) {
            //if (this.items[index].getId() == id) {
            //if (this.items.get(index).getId() == id) {
            if (value.getId() == id) {
                rsl = index;
                break;
            }
            index++;
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
            //this.items[indexFound] = item;
            //this.items[indexFound].setId(id);
            this.items.set(indexFound, item);
            this.items.get(indexFound).setId(id);
            rsl = true;
        }
        return rsl;
    }

    /**
     * метод Tracker.delete, используя indexOf
     * причем вызов indexOf должен быть один.
     * мМетод delete возвращает true, если заявление удалено
     * или false, если index не найдет по id.
     */
    public boolean delete(int id) {
        boolean rsl = false;
        int indexFound = this.indexOf(id);
        if (indexFound != -1) {
            //int lng = (this.size - 1 - indexFound);
            //System.arraycopy(this.items, indexFound + 1, this.items, indexFound, lng);
            //this.items[indexFound + lng] = null;
            this.items.remove(indexFound);
            this.size--;
            rsl = true;
        }
        return rsl;
    }


    @Override
    public String toString() {
        return "Tracker{" +
                //"items=" + Arrays.toString(items) +
                "items=" + items.toString() +
                ", ids=" + ids +
                ", size=" + size +
                //", length=" + length +
                '}';
    }

    public void sort(boolean ascending) {
        if (ascending) {
            items.sort(new SortByNameItemAscending());
        } else {
            items.sort(new SortByNameItemDescending());
        }
    }
}