class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {

        Set<String> s = new HashSet<>();
        for(int[] i : dig){
            StringBuilder sb = new StringBuilder();
            sb.append(i[0]);sb.append("-");sb.append(i[1]);
            s.add(sb.toString());

        }
        int ans =0;
        int k = artifacts.length;
        for(int i=0;i<k;i++){
            int r1 = artifacts[i][0];
            int c1 = artifacts[i][1];
            int r2 = artifacts[i][2];
            int c2 = artifacts[i][3];
            //System.out.println(r1+"--"+c1+"--"+r2+"--"+c2);
            boolean dec = true;
            for(int j=r1;j<=r2;j++){
                for(int l=c1;l<=c2;l++){
                    //System.out.println(j+"--"+l);
                    StringBuilder sb = new StringBuilder();
                    sb.append(j);sb.append("-");sb.append(l);
                    if(!s.contains(sb.toString())){
                        dec = false;
                        break;
                    }
                }
                if(!dec) break;
            }
            if(dec)ans++;
            //System.out.println(i);
        }
        return ans;
    }
}