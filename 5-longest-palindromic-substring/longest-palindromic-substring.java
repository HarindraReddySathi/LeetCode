class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        char[] ch= s.toCharArray();

        int[] bound = new int[2];
        int max = 1;

        //oddCase
        for(int i=0;i<n;i++){
            int j=i;
            int k=i;
            while(j>=0 && k<n && ch[j]==ch[k]){
                int len = k-j+1;
                if(len>max){
                    max=len;bound[0]=j;bound[1]=k;
                }
                 j--;k++;
            }
        }

        //evenCase
        for(int i=1;i<n;i++){
            int j=i-1;
            int k=i;
            while(j>=0 && k<n && ch[j]==ch[k]){
                int len = k-j+1;
                if(len>max){
                    max=len;bound[0]=j;bound[1]=k;
                }
                j--;k++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=bound[0];i<=bound[1];i++)sb.append(ch[i]);
        return sb.toString();
    }
}