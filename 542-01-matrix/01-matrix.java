class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] isVisited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                    isVisited[i][j]=true;
                }
            }
        }
        int count =1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0;j<size;j++){
                Pair p = q.poll();
                for(int i=0;i<4;i++){
                    int x = p.x+dir[i][0];
                    int y = p.y+dir[i][1];
                    if(x>=0 && y>=0 && x<m && y<n && !isVisited[x][y]){
                        q.add(new Pair(x,y));
                        isVisited[x][y]=true;
                        mat[x][y]=count;
                    }
                } 
            }
            count++;
        }
        return mat;
    }

    class Pair{
        int x;
        int y;

        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}