package com.samsolutions.norka.statistics;

/**
 * Created by dznor on 24.01.2017.
 */
public interface Traceable<T> {

    public void doBusinessLogic(T t);

    public T calculateBusinessValue();

}