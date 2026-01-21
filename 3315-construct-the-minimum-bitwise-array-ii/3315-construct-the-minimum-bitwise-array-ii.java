class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);

            // Special case: 2 has no valid answer
            if (p == 2) {
                ans[i] = -1;
                continue;
            }

            // Count trailing 1s in binary representation of p
            int temp = p;
            int count = 0;
            while ((temp & 1) == 1) {
                count++;
                temp >>= 1;
            }

            // Minimum possible value
            ans[i] = p - (1 << (count - 1));
        }

        return ans;
    }
}