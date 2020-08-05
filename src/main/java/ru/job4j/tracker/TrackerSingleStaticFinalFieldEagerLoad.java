package ru.job4j.tracker;

public class TrackerSingleStaticFinalFieldEagerLoad {
    private static final TrackerSingleStaticFinalFieldEagerLoad INSTANCE = new TrackerSingleStaticFinalFieldEagerLoad();

    private TrackerSingleStaticFinalFieldEagerLoad() {
    }

    public static TrackerSingleStaticFinalFieldEagerLoad getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingleStaticFinalFieldEagerLoad tracker = TrackerSingleStaticFinalFieldEagerLoad.getInstance();

    }


}
