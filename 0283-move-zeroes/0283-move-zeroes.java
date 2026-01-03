class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while(i<nums.length){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
            i++;
        }
        while(j<nums.length){
            nums[j]=0;
            j++;
        }
        for(int val:nums){
            System.out.print(val+" ");
        }
    }
}