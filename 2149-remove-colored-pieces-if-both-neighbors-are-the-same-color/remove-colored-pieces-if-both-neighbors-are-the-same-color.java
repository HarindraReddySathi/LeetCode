class Solution {
    public boolean winnerOfGame(String colors) {
        
        int n = colors.length();
        char[] ch = colors.toCharArray();
        int[] sum = new int[2];
        int i =0,j=0;
        while(j<n){

            while(j<n && ch[j]=='A'){
                j++;
            }
            if(j-i>2) sum[0]+=(j-i-2);
            i=j;
            while(j<n && ch[j]=='B'){
                j++;
            }
            if(j-i>2) sum[1]+=(j-i-2);
            i=j;
        }
        return sum[0]>sum[1];

    }
}