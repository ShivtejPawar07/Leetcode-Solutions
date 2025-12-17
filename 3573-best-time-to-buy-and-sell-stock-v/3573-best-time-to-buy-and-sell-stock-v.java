
class Solution {
    public long maximumProfit(int[] a, int opLimit) {
        int n = a.length;
        long[][] res = new long[2][n];

        for (int ops = 1; ops <= opLimit; ops++) {
            // res[0] = res[1]
            System.arraycopy(res[1], 0, res[0], 0, n);
            Arrays.fill(res[1], 0);

            long buy = -a[0];
            long sell = a[0];

            for (int i = 1; i < n; i++) {
                res[1][i] = Math.max(
                    res[1][i - 1],
                    Math.max(
                        buy + a[i],    // normal transaction
                        sell - a[i]    // short selling
                    )
                );

                buy = Math.max(buy, res[0][i - 1] - a[i]);
                sell = Math.max(sell, res[0][i - 1] + a[i]);
            }
        }

        return res[1][n - 1];
    }
}
