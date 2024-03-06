class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        if(n==0 || n==1) return n;
        int ans = 1;
        Map<Character,Integer> m = new HashMap<>();
        int i=0;int j=0;
        while(i<n && j<n){
            char c = ch[j];
            if(!m.containsKey(c) || m.get(c)==0){
                m.put(c,m.getOrDefault(c,0)+1);
                j++;
            }else{
                int k = j-i;
                if(k>ans)ans=k;
                while(m.get(c)!=0){
                    char p = ch[i];
                    m.put(p,m.getOrDefault(p,0)-1);
                    i++;
                }
            }
        }
        if(j-i>ans)ans=(j-i);
        return ans;
    }
}