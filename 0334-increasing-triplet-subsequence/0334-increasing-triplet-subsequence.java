class Solution {
    public boolean increasingTriplet(int[] nums) {
         int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;          // update first if current num is smaller
            } else if (num <= second) {
                second = num;         // update second if current num is bigger than first but smaller than second
            } else {
                // num > second -> we found a triplet: first < second < num
                return true;
            }
        }

        return false;  // no triplet found
    }
}