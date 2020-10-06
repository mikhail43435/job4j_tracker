package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleLazyLoadTest {

    @Test
    public void thenLazyLoad() {
        TrackerSingleLazyLoad tracker1 =  TrackerSingleLazyLoad.getInstance();
        TrackerSingleLazyLoad tracker2 = TrackerSingleLazyLoad.getInstance();
        assertThat(tracker1.getTracker(), is(tracker2.getTracker()));
    }
}