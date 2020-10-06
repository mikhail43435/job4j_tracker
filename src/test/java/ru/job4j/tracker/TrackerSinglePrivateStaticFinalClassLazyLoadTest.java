package ru.job4j.tracker;

        import org.junit.Test;
        import static org.hamcrest.Matchers.is;
        import static org.junit.Assert.assertThat;

public class TrackerSinglePrivateStaticFinalClassLazyLoadTest {

    @Test
    public void StaticFinalFieldEagerLoad() {
        TrackerSinglePrivateStaticFinalClassLazyLoad tracker1 =  TrackerSinglePrivateStaticFinalClassLazyLoad.getInstance();
        TrackerSinglePrivateStaticFinalClassLazyLoad tracker2 = TrackerSinglePrivateStaticFinalClassLazyLoad.getInstance();
        assertThat(tracker1.getTracker(), is(tracker2.getTracker()));
    }
}