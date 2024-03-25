class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[][] alpha = new int[26][2];
        alpha[3][0]++;alpha[20][0]--;alpha[17][1]++;alpha[11][1]--;
        int k = s.length();
        char[] ch = s.toCharArray();
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            int row = startPos[0];
            int col = startPos[1];
            int end = -1;
            for(int j=i;j<k;j++){
                row+=alpha[ch[j]-'A'][0];
                col+=alpha[ch[j]-'A'][1];
                if(row>=0 && col>=0 && row<n && col<n) end=j;
                else break;
            }
            ans[i]=end-i+1;
            if(end==-1) ans[i]=0;
        }
        return ans;
    }
}