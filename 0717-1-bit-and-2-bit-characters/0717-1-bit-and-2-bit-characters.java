class Solution {
    public boolean isOneBitCharacter(int[] bits) {
         int i = 0;
        int n = bits.length;

        while (i < n - 1) {            // Stop at last element
            if (bits[i] == 1) {
                i += 2;               // Two-bit character
            } else {
                i += 1;               // One-bit character
            }
        }

        return i == n - 1;            // Check if we end at last index
    }
}