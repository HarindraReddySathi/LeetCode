class Solution {
    public int compress(char[] chars) {
        
        int n = chars.length;
        int i=0;
        int j=0;
        while(i<n && j<n){
            int start=j;
            char c = chars[j];
            while(j<n && chars[j]==c){
                j++;
            }
            chars[i++]=c;
            if(j-start!=1){
                char[] count = String.valueOf(j-start).toCharArray();
                for(char k :count)chars[i++]=k;
            }
        }
        return i;
    }
}