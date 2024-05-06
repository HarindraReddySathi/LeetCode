class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i =0,j=0;
        //System.out.println(v1.length + " -- "+v2.length);
        while(i<v1.length && j<v2.length){
            int v1i = Integer.parseInt(v1[i]);
            int v2i = Integer.parseInt(v2[j]);
            //System.out.println(v1i + " -- "+v2i);
            if(v1i>v2i) return 1;
            else if (v1i<v2i) return-1;
            else{
                i++;
                j++;
            }
        }
        while(i<v1.length){
            int v1i = Integer.parseInt(v1[i]);
            if(v1i!=0) return 1;
            i++;
        }
        while(j<v2.length){
            int v2i = Integer.parseInt(v2[j]);
            if(v2i!=0) return -1;
            j++;
        }
        return 0;
    }
}