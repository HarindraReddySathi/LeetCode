class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] first_low = new int[26];
        int[] second_low = new int[26];
        Arrays.fill(first_low,Integer.MAX_VALUE);
        Arrays.fill(second_low,Integer.MAX_VALUE);
        int[] freq = new int[26];
        int min = Integer.MAX_VALUE;
        //int additional =0;
        char c = '-';
        for(int i=0;i<n;i++){
            int cur = Math.max(Math.abs(points[i][0]),Math.abs(points[i][1]));
            if(cur<=first_low[ch[i]-'a']){
                second_low[ch[i]-'a'] = first_low[ch[i]-'a'];
                first_low[ch[i]-'a'] = cur;
            }else if(cur<second_low[ch[i]-'a']){
                second_low[ch[i]-'a'] = cur;
            }
            freq[ch[i]-'a']++;
        }
        
        for(int i=0;i<26;i++){
             int cur = (first_low[i]!=second_low[i]) ? second_low[i]-1:first_low[i]-1;
            if(min>cur){
                min =cur;
                c = (char)('a'+i);
            }
        }
        
        //System.out.println(c +" -- "+min);
        int ans =0;
        for(int i=0;i<n;i++){
            int cur = Math.max(Math.abs(points[i][0]),Math.abs(points[i][1]));
            System.out.println(cur);
            if(cur<=min)ans++;
        }
        return ans;
    }
}