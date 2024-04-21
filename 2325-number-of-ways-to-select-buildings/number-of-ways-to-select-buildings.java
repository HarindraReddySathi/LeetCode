class Solution {
    public long numberOfWays(String s) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] build = new int[2];
        int[] suffix = new int[n];
        if(ch[n-1]=='1')build[1]++;
        if(ch[n-1]=='0')build[0]++;
        for(int i =n-2;i>=0;i--){
            int dec = ch[i]=='0' ? 1:0;
            int inc = ch[i]=='0' ? 0:1;
            suffix[i]= build[dec];
            build[inc]++;
        }
        long[][] memo = new long[n][2];
        for(int i =n-2;i>=0;i--){
            int dec = ch[i]=='0' ? 0:1;
            int inc = ch[i]=='0' ? 1:0;
            memo[i][dec]=memo[i+1][dec]+suffix[i];
            memo[i][inc]=memo[i+1][inc];
        }

        /*for(int i=0;i<n;i++){
            System.out.print(suffix[i]+" -- ");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(memo[i][0]+" -- ");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(memo[i][1]+" -- ");
        }*/

        long ans =0;
        for(int i=0;i<n-1;i++){
            int inc = ch[i]=='0' ? 1:0;
            ans+=memo[i+1][inc];
        }
        return ans;
    }
}