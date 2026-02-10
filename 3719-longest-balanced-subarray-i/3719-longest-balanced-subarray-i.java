class Solution {
    public int longestBalanced(int[] nums) {
        //  int n = nums.length;
        // int maxLen = 0;

        // for (int i = 0; i < n; i++) {
        //     Set<Integer> evenSet = new HashSet<>();
        //     Set<Integer> oddSet = new HashSet<>();

        //     for (int j = i; j < n; j++) {
        //         if (nums[j] % 2 == 0) {
        //             evenSet.add(nums[j]);
        //         } else {
        //             oddSet.add(nums[j]);
        //         }

        //         if (evenSet.size() == oddSet.size()) {
        //             maxLen = Math.max(maxLen, j - i + 1);
        //         }
        //     }
        // }
        // return maxLen;

        int n=nums.length;
        int maxlen=0;

        for(int i=0;i<n;i++){
            HashSet<Integer>ehs=new HashSet<>();
             HashSet<Integer>ohs=new HashSet<>();

            for(int j=i;j<n;j++){
                if(nums[j]%2==0)
                    ehs.add(nums[j]);
                else
                    ohs.add(nums[j]);
                if (ehs.size() == ohs.size()) {
                    maxlen = Math.max(maxlen, j - i + 1);
                }
            }
            
        }
        return maxlen;
    }
}