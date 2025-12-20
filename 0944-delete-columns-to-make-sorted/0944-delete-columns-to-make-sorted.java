class Solution {
    public int minDeletionSize(String[] strs) {
           int n = strs.length;
        int m = strs[0].length();
        int deleteCount = 0;

        // Traverse each column
        for (int col = 0; col < m; col++) {
            // Check if column is sorted
            for (int row = 1; row < n; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    deleteCount++;
                    break; // No need to check further rows for this column
                }
            }
        }
        return deleteCount;
    }
}