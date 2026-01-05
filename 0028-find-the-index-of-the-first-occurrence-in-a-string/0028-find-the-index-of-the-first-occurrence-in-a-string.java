class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // Loop through haystack
        for (int i = 0; i <= n - m; i++) {

            int j = 0;
            // Compare substring
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // If full needle matched
            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}