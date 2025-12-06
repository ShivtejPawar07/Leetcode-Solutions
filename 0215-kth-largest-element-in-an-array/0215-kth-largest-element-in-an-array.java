class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
      /*  Arrays.sort(nums);
        
        // kth highest = element at length - k
        int kth = nums[nums.length - k];
        return kth;
        */
    }
}