package com.samsolutions.norka.statistics;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by dznor on 26.01.2017.
 */
public class TraceablePostProcessor implements BeanPostProcessor {

//    private static final Logger LOG = LoggerFactory.getLogger(TraceablePostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (o instanceof Traceable) {
            System.out.println("Inside post process before initialization: " + s);
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (o instanceof Traceable) {
            System.out.println("Inside post process after initialization: " + s);
        }
        return o;
    }
}
