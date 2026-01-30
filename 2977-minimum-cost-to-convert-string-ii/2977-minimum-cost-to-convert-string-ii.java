import java.util.*;

class Solution {
    public long minimumCost(
            String source,
            String target,
            String[] original,
            String[] changed,
            int[] cost) {

        int n = source.length();
        final long INF = Long.MAX_VALUE / 4;

        // -----------------------------
        // Step 1: Assign IDs to strings
        // -----------------------------
        Map<String, Integer> id = new HashMap<>();
        int idx = 0;

        for (String s : original) {
            if (!id.containsKey(s)) {
                id.put(s, idx++);
            }
        }
        for (String s : changed) {
            if (!id.containsKey(s)) {
                id.put(s, idx++);
            }
        }

        int m = idx;

        // -----------------------------
        // Step 2: Floyd–Warshall graph
        // -----------------------------
        long[][] dist = new long[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < cost.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // -----------------------------
        // Step 3: DP over source
        // -----------------------------
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;

            // Case 1: No operation
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            // Case 2: Substring operations
            for (String s : id.keySet()) {
                int len = s.length();
                if (i + len > n) continue;

                if (!source.startsWith(s, i)) continue;

                String t = target.substring(i, i + len);
                if (!id.containsKey(t)) continue;

                long c = dist[id.get(s)][id.get(t)];
                if (c != INF) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + c);
                }
            }
        }

        return dp[n] == INF ? -1 : dp[n];
    }
}
