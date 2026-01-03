class Solution {
    public int maxOperations(int[] nums, int k) {
         Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int need = k - num;

            if (map.getOrDefault(need, 0) > 0) {
                count++; // one operation done
                map.put(need, map.get(need) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}