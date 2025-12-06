class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used,
                           List<Integer> curr, List<List<Integer>> result) {
        
        // If current list contains all numbers → valid permutation
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // Try all numbers
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {               // use unused number
                used[i] = true;
                curr.add(nums[i]);

                backtrack(nums, used, curr, result);

                // undo (backtrack)
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }
}
