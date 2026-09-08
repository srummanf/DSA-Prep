/** Problem Statement: Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * Example:
 * Input: [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]] 
 * Intuition: The idea is to traverse the boundary of the board and mark all 'O's that are connected to the boundary. 
 * Then, we can iterate through the board and convert all unmarked 'O's to 'X's, as they are surrounded by 'X's.
 */

import java.util.Arrays;

class G_14_SurroundedRegion {

    void dfs(int i, int j, char[][] board, boolean[][] vis) {
        int rows = board.length;
        int cols = board[0].length;

        // Out of bounds, not O, or already visited
        if (i < 0 || i >= rows
                || j < 0 || j >= cols
                || board[i][j] != 'O'
                || vis[i][j]) {
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

    public static void main(String[] args) {
        G_14_SurroundedRegion obj = new G_14_SurroundedRegion();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        obj.solve(board);

        // Print the modified board
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
