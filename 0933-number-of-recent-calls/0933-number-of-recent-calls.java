import java.util.*;

class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);

        // Remove old requests
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}
