class Solution {
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int minimum = Integer.MAX_VALUE;

        // Find the minimum complexity
        for (int i = 0; i < n; i++) {
            minimum = Math.min(minimum, complexity[i]);
        }

        // Root must have the minimum complexity
        if (complexity[0] != minimum) {
            return 0;
        }

        // No other computer can have the same minimum complexity
        for (int i = 1; i < n; i++) {
            if (complexity[i] == minimum) {
                return 0;
            }
        }

        // Calculate (n-1)! % 1_000_000_007
        long fac = 1;
        for (int i = n - 1; i >= 1; i--) {
            fac = (fac * i) % 1_000_000_007;
        }

        return (int) fac;
    }
}
