class Solution {
    public int countBinarySubstrings(String s) {
         int prevGroup = 0;
        int currGroup = 1;
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroup++;
            } else {
                result += Math.min(prevGroup, currGroup);
                prevGroup = currGroup;
                currGroup = 1;
            }
        }

        result += Math.min(prevGroup, currGroup);
        return result;
    }
}