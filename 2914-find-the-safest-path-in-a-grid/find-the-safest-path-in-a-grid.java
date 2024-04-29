class Solution {
    public int[][] dir = {{0,1}, {-1,0}, {0,-1}, {1,0}};

    public int maximumSafenessFactor(List<List<Integer>> g) {
        
        int n = g.size();
        if(g.get(0).get(0)==1 || g.get(n-1).get(n-1)==1) return 0;
        int[][] grid = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                grid[i][j] = g.get(i).get(j);
                if(grid[i][j]==1) {
                    grid[i][j]=-1;
                    q.add(new int[]{i,j});
                }
            }
        }
        int stage = 1;
        int high = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] cur = q.poll();
                for(int j=0;j<4;j++) {
                    int x = dir[j][0]+cur[0];
                    int y = dir[j][1]+cur[1];
                    if(x<0 || y < 0 || x>=n || y>= n || grid[x][y] !=0) continue;
                    grid[x][y] = stage;
                    if(grid[x][y] > high) high = grid[x][y];
                    q.add(new int[]{x,y});
                }
            }
            stage++;
        }
        int low = 0;
        int ans = 0;

        while(low<=high) {
            int mid = low+((high-low)>>1);
            if(pathExists(grid, mid,n)) {
                ans=mid;
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return ans;
    
    }

    public boolean pathExists(int[][] grid, int mid,int n) {
        if(grid[0][0]<mid || grid[n-1][n-1]<mid) return false;
        boolean[][] isVisited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        isVisited[0][0]=true;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] cur = q.poll();
                for(int j=0;j<4;j++) {
                    int x = dir[j][0]+cur[0];
                    int y = dir[j][1]+cur[1];
                    if(x<0 || y < 0 || x>=n || y>= n || grid[x][y] <mid || isVisited[x][y]) continue;
                    if(x==n-1 && y==n-1) return true;
                    isVisited[x][y]=true;
                    q.add(new int[]{x,y});
                }
            }
        }
        return false;
    }
}