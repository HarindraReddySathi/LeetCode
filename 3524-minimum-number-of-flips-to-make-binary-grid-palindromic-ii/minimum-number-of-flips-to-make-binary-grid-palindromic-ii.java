class Solution {
    public int minFlips(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        List<int[]> l = new ArrayList<>();
        
        boolean[][] check = new boolean[m][n];
        
        int oneCount =0;
        
        int flips =0;
        
        boolean[] dec = new boolean[3];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(check[i][j]) continue;
                check[i][j] = true;
                int[] count = new int[2];
                count[grid[i][j]]++;
                int total = 1;
                
                if(m-1-i>=0 && m-1-i<m && m-1-i!=i){
                    count[grid[m-1-i][j]]++;
                    total++;
                    check[m-1-i][j] = true;
                }
                if(n-1-j>=0 && n-1-j<n && n-1-j!=j){
                    count[grid[i][n-1-j]]++;
                    total++;
                    check[i][n-1-j] = true;
                }
                if(m-1-i>=0 && m-1-i<m && n-1-j>=0 && n-1-j<n && m-1-i!=i && n-1-j!=j){
                    count[grid[m-1-i][n-1-j]]++;
                    total++;
                    check[m-1-i][n-1-j] = true;
                }
                if(count[0]==1 && count[1]==0) dec[1] = true;
                if(count[0]==0 && count[1]==1) dec[0] = true;
                if((count[0]==1 && count[1]==1)) dec[2] = true;
                l.add(count); 
                flips += Math.min(count[0],count[1]);
                oneCount += count[1];
                if(count[0]>count[1]){
                    oneCount -= count[1];
                }else{
                    oneCount += count[0];
                }
            }
        }
        
        /*for(int[] i : l){
            System.out.println(i[0]+" -- "+i[1]);
        }*/
        
        
        
        
        int rem = (oneCount%4);
        //System.out.println("####### "+ rem);
        
        if(rem ==0){
            return flips;
        }else if(rem ==1){
            if((dec[0])||(dec[1] && dec[2])) return flips+1;
            return flips+3;
        }else if(rem ==2){
            if(dec[2]) return flips;
            return flips+2;
        }else{
            if((dec[1])||(dec[0] && dec[2])) return flips+1;
            return flips+3;
        }
    }
}