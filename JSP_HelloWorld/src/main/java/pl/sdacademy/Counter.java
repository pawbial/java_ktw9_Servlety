package pl.sdacademy;

import java.util.concurrent.atomic.AtomicInteger;

public enum  Counter {

    INSTANCE;

    private AtomicInteger counter = new AtomicInteger();

    public Integer getCounter () {
        return counter.incrementAndGet();
    }
}
