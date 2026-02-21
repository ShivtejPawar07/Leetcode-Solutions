class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);  // counts 1s in binary
            
            if (isPrime(setBits)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}