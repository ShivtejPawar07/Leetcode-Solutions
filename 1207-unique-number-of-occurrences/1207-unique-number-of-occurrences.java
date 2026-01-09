class Solution {
    public boolean uniqueOccurrences(int[] arr) {
         Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check uniqueness of frequencies
        Set<Integer> freqSet = new HashSet<>();
        for (int count : freqMap.values()) {
            if (!freqSet.add(count)) {
                return false; // duplicate frequency found
            }
        }

        return true;
    }
}