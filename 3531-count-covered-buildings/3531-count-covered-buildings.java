class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
         Map<Integer, TreeSet<Integer>> rowToCols = new HashMap<>();
        Map<Integer, TreeSet<Integer>> colToRows = new HashMap<>();

        // Build the row and column maps
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            rowToCols.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            colToRows.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }

        int covered = 0;

        // Check each building
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            TreeSet<Integer> cols = rowToCols.get(x);
            TreeSet<Integer> rows = colToRows.get(y);

            // Check left (lower y) and right (higher y)
            Integer left = cols.lower(y);
            Integer right = cols.higher(y);

            // Check above (lower x) and below (higher x)
            Integer above = rows.lower(x);
            Integer below = rows.higher(x);

            if (left != null && right != null && above != null && below != null) {
                covered++;
            }
        }

        return covered;
    }
}