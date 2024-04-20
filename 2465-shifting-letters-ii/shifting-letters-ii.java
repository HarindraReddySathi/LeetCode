class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int n = s.length();
        System.out.println(n);
        int[] shift = new int[n];
        char[] ch = s.toCharArray();
        for(int[] i : shifts){
            int dec = i[2]==0 ? -1 : 1;
            shift[i[0]] +=dec;
            if(i[1]+1<n) shift[i[1]+1] +=(-1*dec);
        }
        for(int i=1;i<n;i++){
            shift[i] = shift[i]+shift[i-1];
        }
        for(int i=0;i<n;i++){
            System.out.println(shift[i]);
        }
        for(int i=0;i<n;i++){
            int dec = shift[i]>=0 ?1 :-1;
            shift[i]*=dec;
            shift[i]%=26;
            shift[i]*=dec;
        }
        for(int i=0;i<n;i++){
            int cur = ch[i]-'a';
            int sh =shift[i]; 
            if(sh<0){
                sh*=-1;
                if(sh<=cur){
                    ch[i]=(char)(cur-sh+'a');
                }else{
                    sh-=(cur+1);
                    ch[i] = (char)('z'-sh);
                }
            }else if(sh==0){
                continue;
            }else{
                ch[i] = (char)(((cur+sh)%26)+'a');
            }
        }
        return String.valueOf(ch);
    }
}