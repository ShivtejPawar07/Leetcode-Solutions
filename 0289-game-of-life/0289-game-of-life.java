class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        int[] dirs = {-1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int liveNeighbors = 0;

                // Count live neighbors using absolute values
                for (int dx : dirs) {
                    for (int dy : dirs) {
                        if (dx == 0 && dy == 0) continue;

                        int x = i + dx, y = j + dy;
                        if (x >= 0 && x < m && y >= 0 && y < n && Math.abs(board[x][y]) == 1) {
                            liveNeighbors++;
                        }
                    }
                }

                // Apply rules
                if (board[i][j] == 1) { 
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = -1; // live -> dead
                    }
                } else { 
                    if (liveNeighbors == 3) {
                        board[i][j] = 2; // dead -> live
                    }
                }
            }
        }

        // Final pass: convert encoded values to 0 or 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                else if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
}