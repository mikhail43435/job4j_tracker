package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.models.Item;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class MemTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item();
        item.setName("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        memTracker.replace(id, bugWithDesc);
        Item d = memTracker.findById(id);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenFiveElementsDeleteThird() {
        MemTracker memTracker = new MemTracker();
        Item bug1 = new Item();
        bug1.setName("Bug1");
        memTracker.add(bug1);
        Item bug2 = new Item();
        bug2.setName("Bug2");
        memTracker.add(bug2);
        Item bug3 = new Item();
        bug3.setName("Bug3");
        memTracker.add(bug3);
        Item bug4 = new Item();
        bug4.setName("Bug4");
        memTracker.add(bug4);
        Item bug5 = new Item();
        bug5.setName("Bu5g");
        memTracker.add(bug5);
        int id = bug3.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenSortAscending() {
        MemTracker memTracker = new MemTracker();
        Item bug1 = new Item();
        bug1.setName("Bug3");
        memTracker.add(bug1);
        Item bug2 = new Item();
        bug2.setName("Bug1");
        memTracker.add(bug2);
        Item bug3 = new Item();
        bug3.setName("Bug2");
        memTracker.add(bug3);
        memTracker.sort(true);
        Item item = memTracker.findAll().get(0);
        String id = bug3.getName();
        assertThat(item, is(bug2));
    }

    @Test
    public void whenSortDescending() {
        MemTracker memTracker = new MemTracker();
        Item bug1 = new Item();
        bug1.setName("G");
        memTracker.add(bug1);
        Item bug2 = new Item();
        bug2.setName("A");
        memTracker.add(bug2);
        Item bug3 = new Item();
        bug3.setName("Z");
        memTracker.add(bug3);

        memTracker.sort(false);
        Item item = memTracker.findAll().get(0);
        String id = bug3.getName();
        assertThat(item, is(bug3));
    }
}