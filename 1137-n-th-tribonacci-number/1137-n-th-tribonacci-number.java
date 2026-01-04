class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0; // T0
        int b = 1; // T1
        int c = 1; // T2

        for (int i = 3; i <= n; i++) {
            int d = a + b + c;  // Tn = Tn-1 + Tn-2 + Tn-3
            a = b;
            b = c;
            c = d;
        }

        return c;
    }
}
