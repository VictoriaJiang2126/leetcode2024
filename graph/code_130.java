package graph;
//https://www.bilibili.com/video/BV1NT4y1d7ed/?spm_id_from=333.1007.top_right_bar_window_history.content.click&vd_source=3b5289b64f49a8c9842175c409fbaa53
//130.被围绕的区域
public class code_130 {
    public static void solve(char[][] board) {

        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;
        if(n == 0) return;
        //查找每一个边上的O，以其为起点向内做dfs
        for(int j=0; j<n; j++){
            if(board[0][j] == 'O'){
                dfs(board,0,j,m,n);
            }
            if(board[m-1][j] == 'O'){
                dfs(board,m-1,j,m,n);
            }
        }
        for(int i=1; i<m-1; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0, m,n);
            }
            if(board[i][n-1] == 'O'){
                dfs(board, i, n-1, m,n);
            }  
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }   
    }

    public static void dfs(char[][] board, int i, int j, int m, int n){
        //边界条件
        if(i < 0 || j < 0 || i > m-1  || j > n-1 || board[i][j] != 'O'){
            return;
        }

        board[i][j] = 'A';

        dfs(board,i,j-1,m,n);//左
        dfs(board,i,j+1,m,n);//右
        dfs(board,i+1,j,m,n);//下
        dfs(board,i-1,j,m,n);//上
    } 
    public static void main(String args[]){
        //char[][] board = {{'O','O'},{'O','O'}};
        char[][] board = {
            {'X', 'O', 'X', 'O', 'X', 'O'},
            {'O', 'X', 'O', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'O', 'X', 'O'},
            {'O', 'X', 'O', 'X', 'O', 'X'}
        };
        solve(board);
    }
}
