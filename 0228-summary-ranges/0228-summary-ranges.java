class Solution {
    public List<String> summaryRanges(int[] nums) {
         List<String> res = new ArrayList<>();

        if (nums.length == 0) return res;

        int start = nums[0];  // beginning of current range

        for (int i = 1; i < nums.length; i++) {

            // If the sequence breaks
            if (nums[i] != nums[i - 1] + 1) {

                // If start == previous → single number
                if (start == nums[i - 1]) {
                    res.add(String.valueOf(start));
                } else {
                    res.add(start + "->" + nums[i - 1]);
                }

                // start new range
                start = nums[i];
            }
        }

        // Handle the last range after loop
        if (start == nums[nums.length - 1]) {
            res.add(String.valueOf(start));
        } else {
            res.add(start + "->" + nums[nums.length - 1]);
        }

        return res;
    }
}