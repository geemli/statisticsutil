package com.samsolutions.norka.statistics;

/**
 * Created by dznor on 25.01.2017.
 */
public class TraceableProxy<T> implements Traceable<T> {

    Traceable<T> traceable;
    Statistic statistic;

    public TraceableProxy(Traceable<T> traceable, Statistic statistic) {
        this.traceable = traceable;
        this.statistic = statistic;
    }

    @Override
    public void doBusinessLogic(T t) {
        long start = System.nanoTime();
        traceable.doBusinessLogic(t);
        long end = System.nanoTime();
        long time = end - start;
        statistic.addValue(time, "doBusinessLogic");
    }

    @Override
    public T calculateBusinessValue() {
        long start = System.nanoTime();
        T result = traceable.calculateBusinessValue();
        long end = System.nanoTime();
        long time = end - start;
        statistic.addValue(time, "calculateBusinessValue");
        return result;
    }
}
