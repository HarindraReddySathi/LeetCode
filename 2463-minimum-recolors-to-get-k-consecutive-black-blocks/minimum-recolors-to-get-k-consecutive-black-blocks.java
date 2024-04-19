class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();
        char[] ch = blocks.toCharArray();
        int j=0,count =0,ans=Integer.MAX_VALUE,temp=0;
        for(int i=0;i<n;i++){
            while(j<n && temp+count<k){
                if(ch[j]=='B') count++;
                else temp++;
                j++;
            }
            //System.out.println(i+"--"+j+"--"+temp);
            if(temp<ans && temp+count>=k) ans = temp;
            if(ch[i]=='B') count--;
            else temp--;
        }
        return ans;
    }
}