class Solution {
    public int findMin(int[] nums) {
       int left = 0, right = nums.length - 1;
        
        // If array is already sorted
        if(nums[left] < nums[right]) return nums[left];

        while(left < right){
            int mid = left + (right - left) / 2;
            
            // Mid element is greater than right → min is to the right
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } 
            else {
                // min is at mid or to the left
                right = mid;
            }
        }

        return nums[left];  // left == right is the index of minimum
    }
}