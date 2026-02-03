class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int i = 1;

        // 1️⃣ strictly increasing
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }
        if (i == 1 || i == n) return false;

        // 2️⃣ strictly decreasing
        while (i < n && nums[i] < nums[i - 1]) {
            i++;
        }
        if (i == n) return false;

        // 3️⃣ strictly increasing again
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }

        return i == n;
    }
}
