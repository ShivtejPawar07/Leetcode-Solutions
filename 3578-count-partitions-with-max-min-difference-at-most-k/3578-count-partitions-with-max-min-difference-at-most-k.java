class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int MOD = 1_000_000_007;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int l = 0;

        for (int i = 0; i < n; i++) {

            // insert nums[i] into max deque
            while (!maxD.isEmpty() && nums[maxD.peekLast()] < nums[i])
                maxD.pollLast();
            maxD.addLast(i);

            // insert nums[i] into min deque
            while (!minD.isEmpty() && nums[minD.peekLast()] > nums[i])
                minD.pollLast();
            minD.addLast(i);

            // shrink left pointer l until condition satisfied
            while (nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {
                if (maxD.peekFirst() == l) maxD.pollFirst();
                if (minD.peekFirst() == l) minD.pollFirst();
                l++;
            }

            // dp[i+1] = prefix[i] - prefix[l-1]
            dp[i + 1] = prefix[i];
            if (l > 0) dp[i + 1] = (dp[i + 1] - prefix[l - 1] + MOD) % MOD;

            // update prefix
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % MOD;
        }

        return (int) dp[n];
    }
}
