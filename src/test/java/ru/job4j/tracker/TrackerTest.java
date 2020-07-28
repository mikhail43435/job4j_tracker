package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenFiveElementsDeleteThird() {
        Tracker tracker = new Tracker();
        Item bug1 = new Item();
        bug1.setName("Bug1");
        tracker.add(bug1);
        Item bug2 = new Item();
        bug2.setName("Bug2");
        tracker.add(bug2);
        Item bug3 = new Item();
        bug3.setName("Bug3");
        tracker.add(bug3);
        Item bug4 = new Item();
        bug4.setName("Bug4");
        tracker.add(bug4);
        Item bug5 = new Item();
        bug5.setName("Bu5g");
        tracker.add(bug5);
        int id = bug3.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}