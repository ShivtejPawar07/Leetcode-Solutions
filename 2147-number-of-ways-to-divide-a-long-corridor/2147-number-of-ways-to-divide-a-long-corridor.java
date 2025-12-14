class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1000000007;

        int seatCount = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') seatCount++;
        }

        // If seats are odd or less than 2
        if (seatCount == 0 || seatCount % 2 != 0) {
            return 0;
        }

        long ways = 1;
        int seatsSeen = 0;
        int plants = 0;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatsSeen++;

                // After completing one section (2 seats)
                if (seatsSeen > 2 && seatsSeen % 2 == 1) {
                    ways = (ways * (plants + 1)) % MOD;
                    plants = 0;
                }
            } else if (seatsSeen >= 2 && seatsSeen % 2 == 0) {
                plants++;
            }
        }

        return (int) ways;
    }
}
