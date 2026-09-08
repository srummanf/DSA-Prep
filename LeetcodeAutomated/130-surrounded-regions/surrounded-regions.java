class Solution {

    public void dfs(int i, int j, char[][] board, boolean[][] vis) {
        int rows = board.length;
        int cols = board[0].length;

        // Out of bounds, not O, or already visited
        if (i < 0 || i >= rows ||
            j < 0 || j >= cols ||
            board[i][j] != 'O' ||
            vis[i][j]) {
            return;
        }

        vis[i][j] = true;

        // Down
        dfs(i + 1, j, board, vis);

        // Up
        dfs(i - 1, j, board, vis);

        // Right
        dfs(i, j + 1, board, vis);

        // Left
        dfs(i, j - 1, board, vis);
    }

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        // Check Top and Bottom boundaries
        for (int j = 0; j < n; j++) {

            if (board[0][j] == 'O') {
                dfs(0, j, board, vis);
            }

            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j, board, vis);
            }
        }

        // Check Left and Right boundaries
        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O') {
                dfs(i, 0, board, vis);
            }

            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1, board, vis);
            }
        }

        // Convert surrounded O's to X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}