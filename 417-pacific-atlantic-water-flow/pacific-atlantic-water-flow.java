class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
         
        int m = heights.length;
        int n = heights[0].length;
        int[][] checkP = new int[m][n];
        int[][] checkA = new int[m][n];
        //1-- any one sea && 2-- both the sea
        //for pacific if 0 then it is not visisted
        //for atlantic if 0 or 1 it is not visited
        //at last check the boxes with value 2

        //finding places from which water can flow to pacific
        int i=0,j=0;
        while(j<n){
            DFS(heights,checkP,i,j,m,n,-1);
            j++;
        }
        i=0;j=0;
        while(i<m){
            DFS(heights,checkP,i,j,m,n,-1);
            i++;
        }
        //finding places from which water can flow to Atlantic
        i=m-1;j=n-1;
        while(j>=0){
            DFS(heights,checkA,i,j,m,n,-1);
            j--;
        }
        i=m-2;j=n-1;
        while(i>=0){
            DFS(heights,checkA,i,j,m,n,-1);
            i--;
        }
        return ansCreator(checkP,checkA,m,n); 
    }

    public void DFS(int[][] heights,int[][] check,int i,int j,int m,int n,int prev){
        if(i>=m || j>=n || i<0 ||j<0 || check[i][j]!=0 || heights[i][j]<prev) return;
        check[i][j]++;
        DFS(heights,check,i-1,j,m,n,heights[i][j]);
        DFS(heights,check,i+1,j,m,n,heights[i][j]);
        DFS(heights,check,i,j-1,m,n,heights[i][j]);
        DFS(heights,check,i,j+1,m,n,heights[i][j]);
    }
    public List<List<Integer>> ansCreator(int[][] checkP,int[][] checkA,int m,int n){
        List<List<Integer>> ans = new ArrayList<>();
         for(int k=0;k<m;k++){
            for(int l=0;l<n;l++){
                if(checkP[k][l]!=0 && checkA[k][l]!=0){
                    List<Integer> in = new ArrayList<>();
                    in.add(k);
                    in.add(l);
                    ans.add(in);
                }
            }
        }
        return ans;
    }
}