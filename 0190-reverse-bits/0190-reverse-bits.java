class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;          // Shift result left
            result |= (n & 1);     // Add last bit of n
            n >>= 1;               // Shift n right
        }

        return result;
    }
}