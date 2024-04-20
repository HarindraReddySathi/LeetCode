class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        maze[entrance[0]][entrance[1]]='+';
        int ans =0;
        while(!q.isEmpty()){
            ans++;
            int size = q.size();
            for(int i =0;i<size;i++){
                int[] cur = q.poll();
                for(int[] j : dir){
                    int x = cur[0]+j[0];
                    int y = cur[1]+j[1];
                    if(x>=0 && x<m && y>=0 && y<n && maze[x][y]=='.'){
                        if((x==0 || x==m-1 || y==0 || y==n-1)) return ans;
                        int[] temp = new int[2];
                        temp[0]=x;
                        temp[1]=y;
                        q.add(temp);
                        maze[x][y]='+';
                    }
                }

            }
        }
        return -1;
    }
}