package org.example;

import java.util.List;
import java.util.LinkedList;

public final class ActionCounter {
    private static final int TIME_THRESHOLD = 300;
    private final List<Integer> actions;

    public ActionCounter() {
        this.actions = new LinkedList<>();
    }

    public void call(int timestamp) {
        actions.add(timestamp);
    }

    public int getActions(int timestamp) {
        int count = 0;
        for (int action : actions) {
            if (timestamp - action >= 0 && timestamp - action < TIME_THRESHOLD) {
                count++;
            }
        }
        return count;
    }
}
