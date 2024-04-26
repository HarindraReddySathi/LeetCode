class Solution {
    public int longestPalindrome(String[] words) {
        
        int n = words.length;
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        int ans = 0;
        boolean dec = false;
        for(String s : map.keySet()){
            if(s.charAt(0) == s.charAt(1)) {
                int cur = map.get(s);
                if(cur%2 == 0) ans+=cur*2;
                else {
                    ans+=(cur-1)*2;
                    if(!dec) {
                        ans+=2;
                        dec = true;
                    } 
                }
            } else {
                int cur = map.get(s);
                char[] ch = s.toCharArray();
                ch[1] = (char)((ch[0]+ch[1])-(ch[0]=ch[1]));
                String rev = String.valueOf(ch);
                if(map.containsKey(rev)) ans+=(Math.min(map.get(rev), cur)*2);
            }
        }
        return ans;
    }
}