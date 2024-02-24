class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] check = new boolean[m][n];
        for(int i=0;i<m;i++){
            int j=0;
            DFS(board,check,i,j,m,n);
            j=n-1;
            DFS(board,check,i,j,m,n);
        }
        for(int j=0;j<n;j++){
            int i=0;
            DFS(board,check,i,j,m,n);
            i=m-1;
            DFS(board,check,i,j,m,n);
        }
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!check[i][j])board[i][j]='X';
            }
         }
    }

    public void DFS(char[][] board,boolean[][] check,int i,int j,int m,int n){
        if(i<0 ||j<0 || i>=m ||j>=n || check[i][j] || board[i][j]=='X') return;
        check[i][j]=true;
        DFS(board,check,i-1,j,m,n);
        DFS(board,check,i+1,j,m,n);
        DFS(board,check,i,j-1,m,n);
        DFS(board,check,i,j+1,m,n);
    }
}