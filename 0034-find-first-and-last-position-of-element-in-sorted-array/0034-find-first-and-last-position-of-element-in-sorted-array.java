class Solution {
   public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                ans = mid;           // possible answer
                right = mid - 1;     // look left for earlier index
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                ans = mid;           // possible answer
                left = mid + 1;      // look right for later index
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }
}