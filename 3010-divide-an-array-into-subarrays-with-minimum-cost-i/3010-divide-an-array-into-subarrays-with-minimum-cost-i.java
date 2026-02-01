class Solution {
    public int minimumCost(int[] nums) {
         int n = nums.length;
        int ans = Integer.MAX_VALUE;

        // i = start of second subarray
        // j = start of third subarray
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                int cost = nums[0] + nums[i] + nums[j];
                ans = Math.min(ans, cost);
            }
        }
        return ans;
    }
}