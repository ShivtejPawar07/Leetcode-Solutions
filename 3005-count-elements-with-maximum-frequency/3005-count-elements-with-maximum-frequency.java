class Solution {
    public int maxFrequencyElements(int[] nums) {
       int[] freq = new int[101];  // nums[i] ≤ 100
        
        for (int n : nums) {
            freq[n]++;
        }
        
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }
        
        int total = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                total += f;   // add all occurrences of max freq elements
            }
        }
        
        return total;
    }
}