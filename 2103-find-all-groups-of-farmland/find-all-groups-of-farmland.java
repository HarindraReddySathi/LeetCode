class Solution {
    public int[][] findFarmland(int[][] land) {
        
        int m = land.length;
        int n = land[0].length;
        boolean[][] isVisited = new boolean[m][n];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            boolean dec = true;
            for(int j=0;j<n;j++){
                if( land[i][j]==1 && dec){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);l.add(j);
                    marking(land,i,j,l,m,n);
                    ans.add(l);
                    dec = false;
                    //for(int p : land[0])System.out.print(p+" -- ");
                }else if(land[i][j]==-1) dec = !dec;
            }
        }
        int[][] res = new int[ans.size()][4];
        for(int i=0;i<ans.size();i++){
            res[i][0]=ans.get(i).get(0);
            res[i][1]=ans.get(i).get(1);
            res[i][2]=ans.get(i).get(2);
            res[i][3]=ans.get(i).get(3);
        }
        return res;
    }
    public void marking(int[][] grid,int i,int j,List<Integer> l,int m,int n){

        grid[i][j]=-1;
        int x = i;
        while(x<m){
            if(grid[x][j]==0)break;
            else grid[x][j] =-1;
            x++;
        }
        int y = j;
        while(y<n){
            if(grid[i][y]==0)break;
            y++;
        }
        l.add(x-1);l.add(y-1);
        if(y==n) return;
        while(--x>=i) grid[x][y]=-1;
    }
}