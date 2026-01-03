class Solution {
   boolean isPossible(int[] nums, int n, boolean right, int index) {
        // create a copy of array (like vector<int> temp)
        int[] temp = nums.clone();

        // process start
        while (index >= 0 && index <= n - 1) {
            if (temp[index] == 0) {
                if (right) {
                    index++;
                } else {
                    index--;
                }
            } 
            else { // temp[index] > 0
                temp[index]--;

                if (right) {
                    right = false;
                    index--;
                } else {
                    right = true;
                    index++;
                }
            }
        }

        // check if all elements become 0
        for (int j = 0; j < n; j++) {
            if (temp[j] != 0) {
                return false;
            }
        }
        return true;
    }

    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                boolean rightPossible = isPossible(nums, n, true, i);
                boolean leftPossible  = isPossible(nums, n, false, i);

                if (rightPossible && leftPossible) {
                    count += 2;
                } 
                else if (rightPossible || leftPossible) {
                    count += 1;
                }
            }
        }
        return count;
    }
}