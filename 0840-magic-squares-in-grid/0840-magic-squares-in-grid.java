class Solution {
   public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagic(int[][] a, int r, int c) {
        // center must be 5
        if (a[r + 1][c + 1] != 5) return false;

        boolean[] seen = new boolean[10]; // 1 to 9

        // check numbers 1 to 9 and uniqueness
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = a[i][j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }

        int magicsum = 15; // since numbers 1-9, sum is always 15

        // check rows
        for (int i = r; i < r + 3; i++) {
            int rowsum = 0;
            for (int j = c; j < c + 3; j++) {
                rowsum += a[i][j];
            }
            if (rowsum != magicsum) return false;
        }

        // check columns
        for (int j = c; j < c + 3; j++) {
            int colsum = 0;
            for (int i = r; i < r + 3; i++) {
                colsum += a[i][j];
            }
            if (colsum != magicsum) return false;
        }

        // check diagonals
        int d1 = a[r][c] + a[r + 1][c + 1] + a[r + 2][c + 2];
        int d2 = a[r][c + 2] + a[r + 1][c + 1] + a[r + 2][c];
        if (d1 != magicsum || d2 != magicsum) return false;

        return true;
    }
}