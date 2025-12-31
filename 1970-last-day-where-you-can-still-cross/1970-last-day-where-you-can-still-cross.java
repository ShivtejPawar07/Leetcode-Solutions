class Solution {
    int R, C;
    int[][] cells;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.R = row;
        this.C = col;
        this.cells = cells;

        int low = 0, high = row * col, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canCross(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canCross(int day) {
        int[][] grid = new int[R][C];

        // Flood cells up to 'day'
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[R][C];

        // Start BFS from top row
        for (int c = 0; c < C; c++) {
            if (grid[0][c] == 0) {
                q.offer(new int[]{0, c});
                vis[0][c] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == R - 1) return true; // reached bottom

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C &&
                    !vis[nr][nc] && grid[nr][nc] == 0) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
