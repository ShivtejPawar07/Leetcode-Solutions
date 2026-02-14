class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // Create a DP table for 100 rows (max rows = 100)
        double[][] dp = new double[101][101];
        
        // Pour all champagne into the top glass
        dp[0][0] = poured;
        
        // Simulate the tower
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1) { // If current glass overflows
                    double overflow = (dp[i][j] - 1) / 2.0;
                    dp[i][j] = 1;  // Keep max 1 cup in current glass
                    dp[i + 1][j] += overflow;     // Left glass below
                    dp[i + 1][j + 1] += overflow; // Right glass below
                }
            }
        }
        
        // Return how full the target glass is
        return dp[query_row][query_glass];
    }
}