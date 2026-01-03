class Solution {
    public boolean isValidSudoku(char[][] board) {
         for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) return false;
                    set.add(c);
                }
            }
        }

        // Column check
        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) return false;
                    set.add(c);
                }
            }
        }

        // 3x3 Sub-box check
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                Set<Character> set = new HashSet<>();
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        char c = board[i][j];
                        if (c != '.') {
                            if (set.contains(c)) return false;
                            set.add(c);
                        }
                    }
                }
            }
        }

        return true;
    }
}