class Solution {
    public String stringHash(String s, int k) {
        
        int n = s.length();
        char[] ch = s.toCharArray();
        char[] response = new char[n/k];

        for(int i=0;i<n;i=i+k){
            int sum =0;
            for(int j=0;j<k;j++){
                sum += (ch[i+j]-'a');
            }
            response[i/k] = (char) ((sum%26)+'a');
        }

        return String.valueOf(response);
    }
}