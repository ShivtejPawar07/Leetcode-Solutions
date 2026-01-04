class Solution {
    public int sumFourDivisors(int[] nums) {
       int summ = 0;

        for (int i = 0; i < nums.length; i++) {
            int cnt = 0, sum = 0;
            int n = nums[i];

            for (int j = 1; j * j <= n; j++) {
                if (n % j == 0) {
                    int d1 = j;
                    int d2 = n / j;

                    if (d1 == d2) {
                        cnt++;
                        sum += d1;
                    } else {
                        cnt += 2;
                        sum += d1 + d2;
                    }

                    if (cnt > 4) break; // optimization
                }
            }

            if (cnt == 4) {
                summ += sum;
            }
        }
        return summ;
    }
}