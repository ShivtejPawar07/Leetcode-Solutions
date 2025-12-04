class Solution {
    public double myPow(double x, int n) {
         long N = n;  // convert to long to handle Integer.MIN_VALUE safely

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;
        while (N > 0) {
            if ((N & 1) == 1) {  // if N is odd
                result *= x;
            }
            x *= x;
            N >>= 1;  // divide N by 2
        }

        return result;
    }
}