import java.util.*;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();   // FIX 1
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);   // FIX 2

            // even numbers are impossible
            if ((num & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            // count trailing 1s
            int c = 0;
            int temp = num;
            while ((temp & 1) == 1) {
                c++;
                temp >>= 1;
            }

            ans[i] = num - (1 << (c - 1));
        }
        return ans;
    }
}
