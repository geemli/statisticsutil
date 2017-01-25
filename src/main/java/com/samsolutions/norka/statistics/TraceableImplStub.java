package com.samsolutions.norka.statistics;

import org.springframework.context.annotation.Bean;

import java.util.Random;

/**
 * Created by dznor on 24.01.2017.
 */

public class TraceableImplStub implements Traceable<Integer> {

    private final static int MAX_VALUE_SLEEP = 1000;

    Random randomGenerator;

    public TraceableImplStub() {
        randomGenerator = new Random();
    }

    public void doBusinessLogic(Integer integer) {
        System.out.println("doBusinessLogic sleeps " + sleep());
    }

    public Integer calculateBusinessValue() {
        System.out.println("calculateBusinessValue sleeps " + sleep());
        return 10;
    }

    private long sleep() {
        long lat = randomGenerator.nextInt(MAX_VALUE_SLEEP);
        try {
            Thread.sleep(lat);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return lat;
    }
}
