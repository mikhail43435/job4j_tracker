package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleStaticFinalFieldEagerLoadTest {

    @Test
    public void StaticFinalFieldEagerLoad() {
        TrackerSingleStaticFinalFieldEagerLoad tracker1 =  TrackerSingleStaticFinalFieldEagerLoad.getInstance();
        TrackerSingleStaticFinalFieldEagerLoad tracker2 = TrackerSingleStaticFinalFieldEagerLoad.getInstance();
        assertThat(tracker1.getTracker(), is(tracker2.getTracker()));
    }
}