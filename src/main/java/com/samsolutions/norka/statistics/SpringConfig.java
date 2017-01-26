package com.samsolutions.norka.statistics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by dznor on 25.01.2017.
 */

@Configuration
//@ComponentScan(basePackages = "com.samsolutions.norka.statistics")
public class SpringConfig {

    @Bean(name = "traceableImplStub")
    public Traceable getTraceableImplStub() {
        return new TraceableImplStub();
    }

    @Bean(name = "statistic")
    public Statistic getStaticsticBean() {
        return new Statistic();
    }

    @Bean(name = "traceableProxy")
//    @PostConstruct
    public Traceable getTraceableProxy() {
        return new TraceableProxy(getTraceableImplStub(), getStaticsticBean());
    }

    @Bean(name = "traceablePostProcessor")
    public TraceablePostProcessor getTraceablePostProcessor() {
        return new TraceablePostProcessor();
    }
}
