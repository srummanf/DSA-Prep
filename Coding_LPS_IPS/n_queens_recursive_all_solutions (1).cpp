#include <iostream>
using namespace std;
#include <vector>
#include <stack>
void print_board(vector<vector<int>> board)
{
    int n, i, j;
    static int count = 1;
    n = board.size();
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
            cout << board[i][j] << " ";
        cout << endl;
    }
    cout << "Completed " << count++ << endl;
}
bool not_attacked(vector<vector<int>> &board, int row, int col)
{
    int n = board.size(), i, j;
    // check if there is a queen in the same row
    for (j = 0; j < n; j++)
    {
        if ((j != col) && (board[row][j] == 1))
            return 0;
    }
    // Check if there is a queen in same column
    for (i = 0; i < n; i++)
    {
        if ((i != row) && (board[i][col] == 1))
            return 0;
    }
    // both row and column increase
    for (i = row + 1, j = col + 1; i < n && j < n; i++, j++)
    {
        if (board[i][j] == 1)
            return 0;
    }
    // both row and column decrease
    for (i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
    {
        if (board[i][j] == 1)
            return 0;
    }
    // row increase and column decrease
    for (i = row + 1, j = col - 1; i < n && j >= 0; i++, j--)
    {
        if (board[i][j] == 1)
            return 0;
    }
    // row decrease and column increase
    for (i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
    {
        if (board[i][j] == 1)
            return 0;
    }
    return 1;
}
void n_queens(vector<vector<int>> &board, int n, int curr_row)
{
    int i;
    if (curr_row == n)
    {
        print_board(board);
        return;
    }
    for (i = 0; i < n; i++)
    {
        // if the ith column is valid for current row then
        // place queen in column and then goto next row
        // Remove the queen in the ith column and try other
        // columns to right of 'i' - backtrack to find all solutions
        if (not_attacked(board, curr_row, i))
        {
            board[curr_row][i] = 1;
            n_queens(board, n, curr_row + 1);
            board[curr_row][i] = 0;
        }
    }
}
int main()
{
    int n, i, j;
    cin >> n;
    vector<int> row(n, 0);
    vector<vector<int>> board(n, row);

    n_queens(board, n, 0);
    // print_board(board);
}
