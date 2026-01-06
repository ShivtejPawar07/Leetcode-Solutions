class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
         List<Boolean> result = new ArrayList<>();

        // Step 1: Find maximum candies
        int max = 0;
        for (int c : candies) {
            max = Math.max(max, c);
        }

        // Step 2: Check each kid
        for (int c : candies) {
            if (c + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}