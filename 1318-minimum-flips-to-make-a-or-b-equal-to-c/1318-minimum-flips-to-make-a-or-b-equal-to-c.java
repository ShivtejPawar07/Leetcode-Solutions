class Solution {
    public int minFlips(int a, int b, int c) {
         int flips = 0;
        
        while (a > 0 || b > 0 || c > 0) {
            int a_bit = a & 1;
            int b_bit = b & 1;
            int c_bit = c & 1;

            if (c_bit == 0) {
                // both a_bit and b_bit must be 0
                flips += a_bit + b_bit; // add 1 for each bit that is 1
            } else {
                // c_bit == 1, at least one of a_bit or b_bit must be 1
                if (a_bit == 0 && b_bit == 0) {
                    flips += 1;
                }
            }

            // move to next bit
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        
        return flips;
    }
}