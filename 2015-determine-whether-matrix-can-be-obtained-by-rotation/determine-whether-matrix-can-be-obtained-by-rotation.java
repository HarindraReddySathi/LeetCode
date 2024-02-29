class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int count =0;
        while(count<4){
            //System.out.println(count);
            if(equalCheck(mat,target)) return true;
            //print(mat);
            transpose(mat);
            reverse(mat);
            count++;
        }
        return false;
    }
    public void print(int[][] m){
        for(int i =0;i<m.length;i++){
            for(int j=0;j<m.length;j++){
                System.out.print(m[i][j]+"--");
            }
            System.out.println();
        }
    }
    
     public boolean equalCheck(int[][] m ,int[][] n){
        for(int i =0;i<m.length;i++){
            for(int j=0;j<m.length;j++){
                if(m[i][j]!=n[i][j]) return false;
            }
        }
        return true;
    }

    public void reverse(int[][] m ){
        int n = m.length;
        for(int i =0;i<m.length;i++){
            for(int j=0;j<m.length/2;j++){
                int temp = m[i][j];
                m[i][j]=m[i][n-j-1];
                m[i][n-j-1]=temp;
            }
        }
    }

    public void transpose(int[][] m ){
        for(int i =0;i<m.length;i++){
            for(int j=i;j<m.length;j++){
                int temp = m[i][j];
                m[i][j]=m[j][i];
                m[j][i]=temp;
            }
        }
    }
}