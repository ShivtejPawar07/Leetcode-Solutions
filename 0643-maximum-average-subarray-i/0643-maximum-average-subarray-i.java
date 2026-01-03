class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxavg = sum;  // store sum, not avg

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > maxavg) {
                maxavg = sum;
            }
        }

        return maxavg / k;  // finally divide
    }
}
