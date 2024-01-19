package org.example;

import java.util.LinkedList;
import java.util.List;

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

        for (int i = actions.size() - 1; i >= 0; i--) {
            int action = actions.get(i);

            if (timestamp - action >= 0 && timestamp - action < TIME_THRESHOLD) {
                count++;
            } else if (timestamp - action >= TIME_THRESHOLD) {
                break;
            }
        }

        return count;
    }

}
