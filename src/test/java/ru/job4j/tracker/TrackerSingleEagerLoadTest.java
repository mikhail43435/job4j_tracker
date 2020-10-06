package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;



public class TrackerSingleEagerLoadTest {

    @Test
    public void thenEagerLoad() {
        TrackerSingleEagerLoad tracker1 = TrackerSingleEagerLoad.INSTANCE;
        TrackerSingleEagerLoad tracker2 = TrackerSingleEagerLoad.INSTANCE;
        assertThat(tracker1.getTracker(), is(tracker2.getTracker()));
    }
}