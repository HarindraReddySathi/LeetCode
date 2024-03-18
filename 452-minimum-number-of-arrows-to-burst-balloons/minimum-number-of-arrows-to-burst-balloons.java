class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Comparator<int[]> c = new Comparator<>(){

            public int compare(int[] s1,int[] s2){
                return Integer.compare(s1[0],s2[0]);
            }
        };
        Arrays.sort(points,c);
        //for(int[] i : points)System.out.println(i[0]);
        int[] prev = new int[2];
        prev[0]=points[0][0];prev[1]=points[0][1];
        int ans =0;
        for(int i =1;i<n;i++){
            if(points[i][0]>prev[1]){
                ans++;
                prev[0]=points[i][0];prev[1]=points[i][1];
            }else{
                prev[0] = Math.max(prev[0],points[i][0]);
                prev[1] = Math.min(prev[1],points[i][1]);
            }
        }
        return ans+1;
    }
}