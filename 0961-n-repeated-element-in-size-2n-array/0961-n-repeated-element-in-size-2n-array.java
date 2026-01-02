class Solution {
    public int repeatedNTimes(int[] nums) {
        /*Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int cnt=1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    cnt++;
                }
            }
            if(cnt>1){
                return nums[i];
            }
        }
        return 0;
        */
        HashSet<Integer> hs=new HashSet<>();
        for(int val:nums){
            if(!hs.add(val)){
                return val;
            }
        }
        return -1;
    }
}