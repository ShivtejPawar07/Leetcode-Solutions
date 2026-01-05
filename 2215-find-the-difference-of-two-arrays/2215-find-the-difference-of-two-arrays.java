class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
         Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Add elements to sets
        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // nums1 elements not in nums2
        for (int n : set1) {
            if (!set2.contains(n)) {
                list1.add(n);
            }
        }

        // nums2 elements not in nums1
        for (int n : set2) {
            if (!set1.contains(n)) {
                list2.add(n);
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(list1);
        answer.add(list2);

        return answer;
    }
}