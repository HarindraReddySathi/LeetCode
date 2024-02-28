class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> up = new HashSet<>();
        Set<Integer> down = new HashSet<>();
        Set<Integer> x = new HashSet<>();
        Set<Integer> y = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        int[][] temp = new int[n][n];
        queens(ans,up,down,x,y,temp,0,n);
        return ans;
    }

    public void queens(List<List<String>> ans, Set<Integer> up, Set<Integer> down, Set<Integer> x, Set<Integer> y,
            int[][] temp, int level,int n) {
                if(level==n){
                    convertToString(ans,temp,n);
                    return;
                }
                for(int j=0;j<n;j++){
                    if(!up.contains(level+j) && !down.contains(level-j) && !x.contains(level) && !y.contains(j) ){
                        temp[level][j]=1;
                        up.add(level+j);down.add(level-j);x.add(level);y.add(j);
                        queens(ans,up,down,x,y,temp,level+1,n);
                        up.remove(level+j);down.remove(level-j);x.remove(level);y.remove(j);
                        temp[level][j]=0;
                    }
                }
    }

    public void convertToString(List<List<String>> ans,int[][] memo,int n){

        List<String> temp = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(memo[i][j]==0)sb.append(".");
                else sb.append("Q");
            }
            temp.add(sb.toString());
        }
        ans.add(temp);
    }
}