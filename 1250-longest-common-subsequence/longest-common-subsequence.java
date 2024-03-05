class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n1 = text1.length();
        int n2 = text2.length();
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int[][] memo = new int[n1][n2];
        memo[0][0]=(ch1[0]==ch2[0])?1:0;
        for(int i=1;i<n1;i++){
            if(ch1[i]==ch2[0]) memo[i][0]=1;
            else memo[i][0] = memo[i-1][0];
        }
        for(int j=1;j<n2;j++){
            if(ch1[0]==ch2[j]) memo[0][j]=1;
            else memo[0][j] = memo[0][j-1];
        }
        for(int i=1;i<n1;i++){
            for(int j=1;j<n2;j++){
                if(ch1[i]==ch2[j])memo[i][j]=memo[i-1][j-1]+1;
                else memo[i][j]=Math.max(memo[i-1][j],memo[i][j-1]);
            }
        }
        return memo[n1-1][n2-1];
    }
}