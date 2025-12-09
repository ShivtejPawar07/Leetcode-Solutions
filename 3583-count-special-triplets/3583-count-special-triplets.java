class Solution {
    public int specialTriplets(int[] nums) {
         long mod = 1000000007L;

        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0) + 1);
        }

        long total = 0;

        for (int j = 0; j < nums.length; j++) {

            // current element removed from right map
            right.put(nums[j], right.get(nums[j]) - 1);

            int target = nums[j] * 2;

            long leftCount = left.getOrDefault(target, 0);
            long rightCount = right.getOrDefault(target, 0);

            total = (total + (leftCount * rightCount) % mod) % mod;

            // Add nums[j] to left map
            left.put(nums[j], left.getOrDefault(nums[j], 0) + 1);
        }

        return (int)(total % mod);
    }
}