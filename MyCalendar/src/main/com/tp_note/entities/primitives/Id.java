package com.tp_note.entities.primitives;

import java.util.concurrent.atomic.AtomicInteger;

public record Id(int value) {
    private static final AtomicInteger counter = new AtomicInteger();

    public static Id nextValue() {
        return new Id(counter.getAndIncrement());
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
