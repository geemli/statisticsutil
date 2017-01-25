package com.samsolutions.norka.statistics;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by dznor on 24.01.2017.
 */
public class Statistic {

    private final static int MAX_COUNT_OF_SHOWING_ELEMENTS = 3;

    ConcurrentSkipListMap<Long, String> tree;

    public Statistic() {
        tree = new ConcurrentSkipListMap<>(Comparator.reverseOrder());
    }

    public void show3LongestOperations() {
        for (Map.Entry element : tree.entrySet()) {
            System.out.println(element.getKey() + "   " + element.getValue());
        }
    }

    public void addValue(Long key, String value) {
        tree.put(key, value);
    }

}
