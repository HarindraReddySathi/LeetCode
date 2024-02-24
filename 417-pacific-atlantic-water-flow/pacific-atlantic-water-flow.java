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
        //int count=0;
        while(j<n){
            //System.out.println(i+"--"+j);
            DFS(heights,checkP,i,j,m,n,0,-1);
            //print(check,m,n);
            //count++;
            //if(count==3)break;
            j++;
        }
        i=0;j=0;
        while(i<m){
            //System.out.println(i+"--"+j);
            DFS(heights,checkP,i,j,m,n,0,-1);
            //print(check,m,n);
            //count++;
            //if(count==3)break;
            i++;
        }
        //print(check,m,n);
        //finding places from which water can flow to Atlantic
        i=m-1;j=n-1;
        while(j>=0){
            DFS(heights,checkA,i,j,m,n,1,-1);
            j--;
        }
        i=m-2;j=n-1;
        while(i>=0){
            DFS(heights,checkA,i,j,m,n,1,-1);
            i--;
        }
        //print(check,m,n);
        return ansCreator(checkP,checkA,m,n); 
    }

    public void DFS(int[][] heights,int[][] check,int i,int j,int m,int n,int pOrA,int prev){
        if(i>=m || j>=n || i<0 ||j<0 || !decideToPursue(check,i,j,pOrA) || heights[i][j]<prev) return;
        check[i][j]++;
        DFS(heights,check,i-1,j,m,n,pOrA,heights[i][j]);
        DFS(heights,check,i+1,j,m,n,pOrA,heights[i][j]);
        DFS(heights,check,i,j-1,m,n,pOrA,heights[i][j]);
        DFS(heights,check,i,j+1,m,n,pOrA,heights[i][j]);
    }

    public boolean decideToPursue(int[][] check,int i,int j,int pOrA){
        if(pOrA==0){
            if(check[i][j]==0)return true;
            return false;
        }else{
            if(check[i][j]==0)return true;
            return false;
        }
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

    public void print(int[][] check,int m,int n){
        for(int k=0;k<m;k++){
            for(int l=0;l<n;l++){
                System.out.print(check[k][l]+"--");
            }
            System.out.println();
        }
        System.out.println("************************************");
    }
}