package com.samsolutions.norka.statistics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dznor on 25.01.2017.
 */

@Configuration
@ComponentScan
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
    public Traceable getTraceableProxy() {
        return new TraceableProxy(getTraceableImplStub(), getStaticsticBean());
    }
}
