class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1] == 1) return -1;
        if (grid[0][0] == 0 && m == 1 && n == 1) return 1;
        int[][] directions = { {0,1}, {-1,-1}, {1,1}, {-1,0}, {-1,1}, {1,0}, {0,-1}, {1,-1} };
        //System.out.println(directions.length);
        boolean[][] isVisisted = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        isVisisted[0][0]=true;
        int level =1;
        while(!q.isEmpty()){
            int size = q.size();
            //System.out.println(size);
            for(int t=0;t<size;t++){
                Pair p = q.poll();
                int i = p.x;
                int j =p.y;
                //System.out.println(i+"--"+j);
                if(i==m-1 && j==n-1) return level;
                for(int k =0;k<directions.length;k++){
                    int x = i+directions[k][0];
                    int y = j+directions[k][1];
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==0 && !isVisisted[x][y]){
                        q.add(new Pair(x,y));
                        isVisisted[x][y]=true;
                        //System.out.println(x+"--"+y);
                    }
                }
            }
            level++;
        }
        return -1;
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