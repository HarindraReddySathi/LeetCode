class Solution {
    public boolean canReachCorner(int X, int Y, int[][] circles) {
        
        int n = circles.length;
        
        List<int[]> edges = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isIntersected(circles[i],circles[j])){
                    edges.add(new int[]{i,j});
                }
            }
        }
        
        long[][] unionFind = new long[n][6];
        for(int i=0;i<n;i++){
            unionFind[i][0]=i;
            unionFind[i][1]=1;
            unionFind[i][2]=circles[i][0]-circles[i][2];
            unionFind[i][3]=circles[i][0]+circles[i][2];
            unionFind[i][4]=circles[i][1]-circles[i][2];
            unionFind[i][5]=circles[i][1]+circles[i][2];
            if((unionFind[i][2]<=0 && unionFind[i][3]>=X)||(unionFind[i][4]<=0 && unionFind[i][5]>=Y)||(unionFind[i][2]<=0 && unionFind[i][4]<=0) || (unionFind[i][3]>=X && unionFind[i][5]>=Y)) return false;
        }
        
        
        for(int[] edge : edges){
            
            int left = (int)findParent(edge[0],unionFind);
            int right = (int)findParent(edge[1],unionFind);
            
            if(left==right){
                continue;
            }
            
            if(unionFind[left][1]>=unionFind[right][1]){
                unionFind[right][0] = unionFind[left][0];
                unionFind[left][1]+=unionFind[right][1];
                
                unionFind[left][2] = Math.min(unionFind[left][2],unionFind[right][2]);
                unionFind[left][4] = Math.min(unionFind[left][4],unionFind[right][4]);
                unionFind[left][3] = Math.max(unionFind[left][3],unionFind[right][3]);
                unionFind[left][5] = Math.max(unionFind[left][5],unionFind[right][5]);
                
                if((unionFind[left][2]<=0 && unionFind[left][3]>=X)||(unionFind[left][4]<=0 && unionFind[left][5]>=Y)||(unionFind[left][2]<=0 && unionFind[left][4]<=0) || (unionFind[left][3]>=X && unionFind[left][5]>=Y)) return false;
                
            }else{
                unionFind[left][0] = unionFind[right][0];
                unionFind[right][1]+=unionFind[left][1];
                
                unionFind[right][2] = Math.min(unionFind[left][2],unionFind[right][2]);
                unionFind[right][4] = Math.min(unionFind[left][4],unionFind[right][4]);
                unionFind[right][3] = Math.max(unionFind[left][3],unionFind[right][3]);
                unionFind[right][5] = Math.max(unionFind[left][5],unionFind[right][5]);
                
                if((unionFind[right][2]<=0 && unionFind[right][3]>=X)||(unionFind[right][4]<=0 && unionFind[right][5]>=Y)||(unionFind[right][2]<=0 && unionFind[right][4]<=0) || (unionFind[right][3]>=X && unionFind[right][5]>=Y)) return false;
            }
            
        }
        
        return true;
        
    }
    
    public int findParent(int i , long[][] unionFind){
        
        if(unionFind[i][0]!=i){
            unionFind[i][0] = (int)findParent((int)unionFind[i][0],unionFind);
        }
        return (int)unionFind[i][0];
    }
    
    public boolean isIntersected(int[] c1, int[] c2){
        int dx = c1[0] - c2[0];  // Difference in x coordinates
        int dy = c1[1] - c2[1];  // Difference in y coordinates
        int distanceSquared = dx * dx + dy * dy;  // Square of the distance between centers
        int radiusSum = c1[2] + c2[2];  // Sum of the radii
        return distanceSquared <= radiusSum * radiusSum;  // Check if distance is less than or equal to radius sum
    }
}