import java.util.*;

public class Solution {

    static class Event implements Comparable<Event> {
        long y, x1, x2;
        int type;

        Event(long y, long x1, long x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }

        public int compareTo(Event other) {
            if (this.y != other.y)
                return Long.compare(this.y, other.y);
            return Integer.compare(other.type, this.type); // start before end
        }
    }

    static class Node {
        int count = 0;
        long length = 0;
    }

    List<Long> coords;
    Node[] tree;

    void update(int node, int start, int end, long l, long r, int val) {
        if (coords.get(end + 1) <= l || coords.get(start) >= r)
            return;

        if (l <= coords.get(start) && coords.get(end + 1) <= r) {
            tree[node].count += val;
        } else {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, l, r, val);
            update(node * 2 + 1, mid + 1, end, l, r, val);
        }

        if (tree[node].count > 0) {
            tree[node].length = coords.get(end + 1) - coords.get(start);
        } else if (start != end) {
            tree[node].length = tree[node * 2].length + tree[node * 2 + 1].length;
        } else {
            tree[node].length = 0;
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        TreeSet<Long> xSet = new TreeSet<>();

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, x, x + l, 1));
            events.add(new Event(y + l, x, x + l, -1));
            xSet.add(x);
            xSet.add(x + l);
        }

        Collections.sort(events);
        coords = new ArrayList<>(xSet);

        int n = coords.size();
        tree = new Node[4 * n];
        for (int i = 0; i < tree.length; i++) tree[i] = new Node();

        double totalArea = 0;
        for (int i = 0; i < events.size() - 1; i++) {
            update(1, 0, n - 2, events.get(i).x1, events.get(i).x2, events.get(i).type);
            long dy = events.get(i + 1).y - events.get(i).y;
            if (dy > 0) {
                totalArea += (double) dy * tree[1].length;
            }
        }

        double target = totalArea / 2.0;

        // reset tree
        for (Node node : tree) {
            node.count = 0;
            node.length = 0;
        }

        double currArea = 0;
        for (int i = 0; i < events.size() - 1; i++) {
            update(1, 0, n - 2, events.get(i).x1, events.get(i).x2, events.get(i).type);
            long dy = events.get(i + 1).y - events.get(i).y;
            double width = tree[1].length;

            if (currArea + dy * width >= target) {
                return events.get(i).y + (target - currArea) / width;
            }
            currArea += dy * width;
        }

        return events.get(events.size() - 1).y;
    }
}
