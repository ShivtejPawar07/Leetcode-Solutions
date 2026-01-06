class Solution {
    public int smallestRepunitDivByK(int k) {
          // If k is divisible by 2 or 5, no number made of only 1s can divide it.
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int rem = 0;

        for (int length = 1; length <= k; length++) {
            rem = (rem * 10 + 1) % k;
            if (rem == 0) {
                return length;
            }
        }
        return -1; // Should not reach here normally
    }
}