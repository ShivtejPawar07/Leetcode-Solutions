class Solution {
    public int numOfWays(int n) {
         long MOD = 1_000_000_007;

        long a = 6; // ABA patterns
        long b = 6; // ABC patterns

        for (int i = 2; i <= n; i++) {
            long newA = (a * 3 + b * 2) % MOD;
            long newB = (a * 2 + b * 2) % MOD;
            a = newA;
            b = newB;
        }

        return (int)((a + b) % MOD);
    }
}