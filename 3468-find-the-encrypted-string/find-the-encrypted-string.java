class Solution {
    public String getEncryptedString(String s, int k) {
        
        char[] ch = s.toCharArray();
        int n = ch.length;
        StringBuilder sb = new StringBuilder();
        k %=n;
        for(int i =0,j=k;i<n;i++,j=(j+1)%n){
            sb.append(ch[j]+"");
        }
        return sb.toString();
    }
}