You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:

In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    static void fun(int i,int j,char[][] a){
        if(i<0||j<0||i>=a.length||j>=a[0].length||a[i][j]!='O')
            return;
        a[i][j]='.';
        fun(i-1,j,a);
        fun(i,j-1,a);
        fun(i+1,j,a);
        fun(i,j+1,a);
    }
    public void solve(char[][] a) {
        int r = a.length;
        int c = a[0].length;
        for(int i=0;i<c;i++){
            fun(0,i,a);
            fun(r-1,i,a);
        }
        for(int i=0;i<r;i++){
            fun(i,0,a);
            fun(i,c-1,a);
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(a[i][j]=='O')
                    a[i][j]='X';
                else if (a[i][j]=='.')
                    a[i][j]='O';
            }
        }
    }
}
