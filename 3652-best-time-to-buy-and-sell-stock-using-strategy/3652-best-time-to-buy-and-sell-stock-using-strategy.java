class Solution {
   public long maxProfit(int[] prices, int[] strategy, int k) {
    int n = prices.length;

    // 1. Initial profit
    long baseProfit = 0;
    for (int i = 0; i < n; i++) {
        baseProfit += (long) strategy[i] * prices[i];
    }

    int half = k / 2;

    long[] first = new long[n];
    long[] second = new long[n];

    for (int i = 0; i < n; i++) {
        first[i] = -(long) strategy[i] * prices[i];
        second[i] = (long) (1 - strategy[i]) * prices[i];
    }

    // 2. Initial window delta
    long currDelta = 0;
    for (int i = 0; i < half; i++) currDelta += first[i];
    for (int i = half; i < k; i++) currDelta += second[i];

    long bestDelta = currDelta;

    // 3. Slide the window
    for (int start = 1; start + k <= n; start++) {
        // remove old contributions
        currDelta -= first[start - 1];
        currDelta -= second[start + half - 1];

        // add new contributions
        currDelta += first[start + half - 1];
        currDelta += second[start + k - 1];

        bestDelta = Math.max(bestDelta, currDelta);
    }

    return baseProfit + Math.max(0, bestDelta);
}

}