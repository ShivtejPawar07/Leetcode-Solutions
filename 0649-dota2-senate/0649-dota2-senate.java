import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {

        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();

        // Store positions
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R')
                radiant.add(i);
            else
                dire.add(i);
        }

        // Process rounds
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();

            if (r < d) {
                // Radiant bans Dire
                radiant.add(r + n);
            } else {
                // Dire bans Radiant
                dire.add(d + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
