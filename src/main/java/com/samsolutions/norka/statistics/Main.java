package com.samsolutions.norka.statistics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dznor on 25.01.2017.
 */

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Traceable obj = (TraceableProxy) context.getBean("traceableProxy");
        Statistic statistic = (Statistic) context.getBean("statistic");
        obj.calculateBusinessValue();
        obj.calculateBusinessValue();
        obj.calculateBusinessValue();
        obj.calculateBusinessValue();
        obj.doBusinessLogic(1);
        obj.doBusinessLogic(2);
        obj.doBusinessLogic(3);

        statistic.show3LongestOperations();
    }
}
