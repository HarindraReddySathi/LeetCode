class Solution {
    public boolean exist(char[][] b, String w) {
        
        int m = b.length;
        int n = b[0].length;
        int o = w.length();
        char[] ch = w.toCharArray();
        boolean[][] dec = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(b[i][j]==ch[0]){
                    if(DFS(b,ch,dec,0,i,j,m,n,o)) return true;;
                }
            }
        }
        return false;
    }

    public boolean DFS(char[][] b,char[] ch,boolean[][] dec,int level,int i,int j,int m,int n,int o){

        if(i<0 ||j<0 || i>=m ||j>=n ||ch[level]!=b[i][j]||dec[i][j]) return false;
        if(level==ch.length-1)return true;
       dec[i][j]=true;
        boolean ans =((DFS(b,ch,dec,level+1,i+1,j,m,n,o)) ||
                      (DFS(b,ch,dec,level+1,i-1,j,m,n,o)) || 
                      (DFS(b,ch,dec,level+1,i,j+1,m,n,o)) || 
                      (DFS(b,ch,dec,level+1,i,j-1,m,n,o)));
        dec[i][j]=false;
        return ans;
    }
}