package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.loadtests.TrackerSingleStaticFinalFieldEagerLoad;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MemTrackerSingleStaticFinalFieldEagerLoadTest {

    @Test
    public void staticFinalFieldEagerLoad() {
        TrackerSingleStaticFinalFieldEagerLoad tracker1 =
                TrackerSingleStaticFinalFieldEagerLoad.getInstance();
        TrackerSingleStaticFinalFieldEagerLoad tracker2 =
                TrackerSingleStaticFinalFieldEagerLoad.getInstance();
        assertThat(tracker1.getMemTracker(), is(tracker2.getMemTracker()));
    }
}