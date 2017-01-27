package com.samsolutions.norka.statistics;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by dznor on 24.01.2017.
 */
public class Statistic {

    private final static int MAX_COUNT_OF_SHOWING_ELEMENTS = 3;

    class Info {
        Long time;
        String beanName;

        public Info(Long time, String beanName) {
            this.time = time;
            this.beanName = beanName;
        }

        public Info() {
        }
    }

    ConcurrentSkipListMap<Long, Info> tree = new ConcurrentSkipListMap<Long, Info>(new ByReverseTimeWithDuplicateComparator());

    public void show3LongestOperations() {
        for (Map.Entry element : tree.entrySet()) {
            System.out.println(element.getKey() + "   " + (Info) element.getValue());
        }
    }

    public void addValue(Long key, String value) {
        tree.put(key, new Info());
    }

    class ByReverseTimeWithDuplicateComparator implements Comparator<Long> {
        @Override
        public int compare(Long e1, Long e2) {
            int result = e2.compareTo(e1);
            return result == 0 ? -1 : result;
        }
    }


}
