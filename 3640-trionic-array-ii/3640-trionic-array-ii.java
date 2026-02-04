class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;
        long ans = Long.MIN_VALUE;

        while (i < n) {
            int l = i;
            i++;

            // first increasing
            while (i < n && nums[i - 1] < nums[i]) {
                i++;
            }
            if (i == l + 1) continue;

            int p = i - 1;

            // decreasing
            long s = (long) nums[p - 1] + nums[p];
            while (i < n && nums[i - 1] > nums[i]) {
                s += nums[i];
                i++;
            }
            if (i == p + 1 || i == n || nums[i - 1] == nums[i]) continue;

            int q = i - 1;

            // start second increasing
            s += nums[i];
            i++;

            long mx = 0;
            long t = 0;

            while (i < n && nums[i - 1] < nums[i]) {
                t += nums[i];
                i++;
                mx = Math.max(mx, t);
            }
            s += mx;

            // best prefix from left side
            mx = 0;
            t = 0;
            for (int j = p - 2; j >= l; j--) {
                t += nums[j];
                mx = Math.max(mx, t);
            }
            s += mx;

            ans = Math.max(ans, s);

            i = q; // reset for overlapping
        }

        return ans;
    }
}
