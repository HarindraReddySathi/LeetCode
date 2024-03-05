class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int count=0;
        int m = grid.length;
        int n = grid[0].length;
        int time =0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) count++;
                else if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
        if(count==0) return 0;
        while(!q.isEmpty()){
            time++;
            int size = q.size();
            for(int index=0;index<size;index++) {
                Pair p = q.remove();
                for(int l=0;l<dir.length;l++){
                    int i =p.x+dir[l][0];
                    int j =p.y+dir[l][1];
                    if(i>=0 && j>=0 && i<m && j<n && grid[i][j]==1){
                        grid[i][j]=2;
                        count--;
                        q.add(new Pair(i,j));
                    }
                }
            }

        }
        if(count>0) return -1;
        return time-1;
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