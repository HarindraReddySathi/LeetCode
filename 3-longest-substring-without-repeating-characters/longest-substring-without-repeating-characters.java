class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        if(n<=1) return n;
        int ans =1;
        int i=0;
        int j=1;
        Map<Character,Integer> map = new HashMap<>();
        map.put(ch[0],1);
        while(i<n && j<n){
            if(!map.containsKey(ch[j]) || (map.get(ch[j])==0)){
                map.put(ch[j],1);
                if(ans<(j-i+1)) ans =j-i+1;
                j++;
            }else{
                map.put(ch[i],0);
                i++;
            }
        }
        return ans;
    }
}