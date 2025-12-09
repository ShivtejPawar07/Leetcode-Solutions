class Solution {
    public int majorityElement(int[] nums) {
        int maj=0;
        for(int i=0;i<nums.length;i++){
            int cnt=1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    cnt++;
                }
            }
            if(cnt>nums.length/2){
                maj=nums[i];
                break;
            }
        }
        return maj;
    }
}