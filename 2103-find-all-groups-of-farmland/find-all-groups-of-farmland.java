class Solution {
    public int[][] findFarmland(int[][] land) {
        
        int m = land.length;
        int n = land[0].length;
        boolean[][] isVisited = new boolean[m][n];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if( land[i][j]==1 && !isVisited[i][j]){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);l.add(j);
                    int[] br = new int[2];
                    br[0]=i;br[1]=j;
                    DFS(br,land,isVisited,i,j,m,n);
                    l.add(br[0]);l.add(br[1]);
                    ans.add(l);
                }
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

    public void DFS(int[] br,int[][] land,boolean[][] isVisited,int i,int j,int m,int n){

        if(i<0 || j<0 || i>=m || j>=n || isVisited[i][j] || land[i][j]==0) return;
        if(i>=br[0] && j>=br[1]){
            br[0]=i;br[1]=j;
        }
        isVisited[i][j]=true;
        DFS(br,land,isVisited,i+1,j,m,n);
        DFS(br,land,isVisited,i-1,j,m,n);
        DFS(br,land,isVisited,i,j+1,m,n);
        DFS(br,land,isVisited,i,j-1,m,n);
    }
}