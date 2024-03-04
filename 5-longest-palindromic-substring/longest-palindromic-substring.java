class Solution {
    public String longestPalindrome(String s) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] ans = new int[2];
        int max =1;
        int[] temp = new int[2];
        for(int i=1;i<n;i++){
            maxPalindrome(ch,i,n,temp);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=temp[0];i<=temp[1];i++)sb.append(ch[i]);
        return sb.toString();
    }

    public void maxPalindrome(char[] ch, int i ,int n,int[] temp){
        caseOorE(ch,i,i,n,temp);
        caseOorE(ch,i-1,i,n,temp);
    }

    public void caseOorE(char[] ch,int left,int right,int n,int[] temp){
        int ans =0;
        int dec = (left==right)?-1:0;
        
        while(left>=0 && right<n){
            if(ch[left]==ch[right]) ans++;
            else break;
            left--;right++;
        }
        ans*=2;ans+=dec;
        if((temp[1]-temp[0]+1)<ans){
            temp[0]=left+1;
            temp[1]=right-1;
        }
    }
}