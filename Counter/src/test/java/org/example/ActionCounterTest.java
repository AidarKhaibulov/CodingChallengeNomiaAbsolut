package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActionCounterTest {

    @Test
    public void test1() {
        ActionCounter counter = new ActionCounter();

        counter.call(1);
        counter.call(2);
        counter.call(2);

        assertEquals(3, counter.getActions(4));
        assertEquals(3, counter.getActions(5));
    }

    @Test
    public void test2() {
        ActionCounter counter = new ActionCounter();

        counter.call(100);
        counter.call(200);
        counter.call(300);
        counter.call(400);
        counter.call(500);

        assertEquals(2, counter.getActions(600));
        assertEquals(3, counter.getActions(400));
        assertEquals(1, counter.getActions(100));
        assertEquals(2, counter.getActions(200));
        assertEquals(3, counter.getActions(300));
    }

    @Test
    public void test3() {
        ActionCounter counter = new ActionCounter();

        counter.call(1);
        counter.call(2);
        counter.call(2);
        counter.call(3);
        counter.call(3);

        assertEquals(5, counter.getActions(5));
        assertEquals(5, counter.getActions(3));
        assertEquals(3, counter.getActions(2));
    }
}
