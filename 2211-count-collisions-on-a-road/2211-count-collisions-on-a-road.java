class Solution {
    public int countCollisions(String directions) {
         int n = directions.length();
        int left = 0, right = n - 1;

        // Skip all leading 'L'
        while (left < n && directions.charAt(left) == 'L')
            left++;

        // Skip all trailing 'R'
        while (right >= 0 && directions.charAt(right) == 'R')
            right--;

        int collisions = 0;

        // Count all R and L in the middle portion
        for (int i = left; i <= right; i++) {
            char c = directions.charAt(i);
            if (c == 'R' || c == 'L') collisions++;
        }

        return collisions;
    }
}