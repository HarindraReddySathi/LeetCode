class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        int x = click[0];
        int y = click[1];
        if(board[x][y]=='M'){
            board[x][y]='X';
            return board;
        }
        boolean[][] isVisited = new boolean[m][n];
        int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        isVisited[x][y]=true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Point p = q.poll();
                x=p.x;
                y=p.y;
                int mineCount =0;
                for(int[] j : dir){
                    if(x+j[0]>=0 && y+j[1]>=0 && x+j[0]<m && y+j[1]<n){
                        if(board[x+j[0]][y+j[1]]=='M')mineCount++;
                    }
                }
                if(mineCount!=0)board[x][y]= (char)(mineCount+'0');
                else{
                    board[x][y]='B';
                    for(int[] j : dir){
                        int xc = x+j[0];
                        int yc = y+j[1];
                        if(xc>=0 && yc>=0 && xc<m && yc<n){
                            if(!isVisited[xc][yc] && board[xc][yc]!='M'){
                                q.add(new Point(xc,yc));
                                isVisited[xc][yc]=true;
                            }
                        }
                    }
                }
            }
        }
        return board;
    }

    class Point{
        int x;
        int y;

        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}