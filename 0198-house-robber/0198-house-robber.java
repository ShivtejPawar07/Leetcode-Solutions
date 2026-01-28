class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;  // dp[i-2]
        int prev1 = 0;  // dp[i-1]

        for (int num : nums) {
            int pick = prev2 + num;   // rob this house
            int skip = prev1;         // skip this house

            int curr = Math.max(pick, skip);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}