package ru.job4j.tracker;

import ru.job4j.tracker.comp.SortByNameItemAscending;
import ru.job4j.tracker.comp.SortByNameItemDescending;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.models.Store;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemTracker implements Store {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    @Override
    public void init() throws SQLException {

    }

    /**
     * метод добавляет заявку, переданную в аргументах в массив заявок items
     * поле ids используется для генерации нового ключа
     * в нашем примере мы используем последовательность
     * то есть каждый вызов метод add будет добавлять в поле ids единицу
     * так мы сможем обеспечить уникальность поле id в Item
     */
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        System.out.println("Добавленная заявка: " + item);
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        return replace(Integer.parseInt(id), item);
    }

    @Override
    public boolean delete(String id) {
        return delete(Integer.parseInt(id));
    }

    /**
     * проверяет в цикле все элементы массива items,
     * сравнивая id с аргументом int id
     * и возвращает найденный Item.
     * Если Item не найден - возвращает null.
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * возвращает копию массива items без null элементов (без пустых ячеек)
     */
    public ArrayList<Item> findAll() {
        return this.items;
    }

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
            if (value.getName().equals(key)) {
                itemsWithSameName.add(value);
            }
        }
        return itemsWithSameName;
    }

    @Override
    public Item findById(String id) {
        return findById(Integer.parseInt(id));
    }

    /**
     * метод, который будет возвращать index по id
     */
    private int indexOf(int id) {
        int rsl = -1;
        int index = 0;
        for (Item value : this.items) {
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
            this.items.remove(indexFound);
            this.size--;
            rsl = true;
        }
        return rsl;
    }

    @SuppressWarnings("checkstyle:OperatorWrap")
    @Override
    public String toString() {
        return "Tracker{"
                + "items=" + items.toString()
                + ", ids=" + ids
                + ", size=" + size
                + '}';
    }

    public void sort(boolean ascending) {
        if (ascending) {
            items.sort(new SortByNameItemAscending());
        } else {
            items.sort(new SortByNameItemDescending());
        }
    }

    @Override
    public void close() throws Exception {

    }
}