package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.loadtests.TrackerSingleEagerLoad;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MemTrackerSingleEagerLoadTest {

    @Test
    public void thenEagerLoad() {
        TrackerSingleEagerLoad tracker1 = TrackerSingleEagerLoad.INSTANCE;
        TrackerSingleEagerLoad tracker2 = TrackerSingleEagerLoad.INSTANCE;
        assertThat(tracker1.getMemTracker(), is(tracker2.getMemTracker()));
    }
}