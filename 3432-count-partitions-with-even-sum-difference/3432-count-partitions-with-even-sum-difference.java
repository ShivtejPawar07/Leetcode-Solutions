class Solution {
    public int countPartitions(int[] nums) {
       int total = 0;
        for(int x : nums) total += x;

        // If total sum is odd → no partition gives even difference
        if(total % 2 != 0) return 0;

        // Else, all partitions (0 to n-2) are valid
        return nums.length - 1;
    }
}