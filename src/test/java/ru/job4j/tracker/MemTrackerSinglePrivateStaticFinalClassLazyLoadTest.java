package ru.job4j.tracker;

        import org.junit.Test;
        import ru.job4j.tracker.loadtests.TrackerSinglePrivateStaticFinalClassLazyLoad;

        import static org.hamcrest.Matchers.is;
        import static org.junit.Assert.assertThat;

public class MemTrackerSinglePrivateStaticFinalClassLazyLoadTest {

    @Test
    public void staticFinalFieldEagerLoad() {
        TrackerSinglePrivateStaticFinalClassLazyLoad tracker1 =
                TrackerSinglePrivateStaticFinalClassLazyLoad.getInstance();
        TrackerSinglePrivateStaticFinalClassLazyLoad tracker2 =
                TrackerSinglePrivateStaticFinalClassLazyLoad.getInstance();
        assertThat(tracker1.getMemTracker(), is(tracker2.getMemTracker()));
    }
}