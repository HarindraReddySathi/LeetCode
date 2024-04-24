class Solution {
    public int[][] findFarmland(int[][] land) {
        
        int m = land.length;
        int n = land[0].length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            boolean dec = true;
            for(int j=0;j<n;j++){
                if( land[i][j]==1 && dec){
                    ans.add(i);ans.add(j);
                    marking(land,i,j,ans,m,n);
                    dec = false;
                }else if(land[i][j]==-1) dec = !dec;
            }
        }
        int[][] res = new int[ans.size()/4][4];
        for(int i=0,j=0;i<ans.size();i=i+4,j++){
            res[j][0]=ans.get(i+0);
            res[j][1]=ans.get(i+1);
            res[j][2]=ans.get(i+2);
            res[j][3]=ans.get(i+3);
        }
        return res;
    }
    public void marking(int[][] grid,int i,int j,List<Integer> l,int m,int n){

        grid[i][j]=-1;
        int x = i,y=j;
        while(++x<m){
            if(grid[x][j]==0)break;
            else grid[x][j] =-1;
        }
        while(++y<n) if(grid[i][y]==0)break;
        l.add(x-1);l.add(y-1);
        if(y==n) return;
        while(--x>=i) grid[x][y]=-1;
    }
}