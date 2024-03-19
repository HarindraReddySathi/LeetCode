class Solution {
    public int lengthLongestPath(String input) {
        int ans =0;
        Map<Integer,Integer> map = new HashMap<>();
        for(String str : input.split("\n")){
            int level =str.split("\t").length-1;
            int dec = (level ==0)?0:map.get(level-1);
            if(str.contains("."))ans = Math.max(ans,dec+str.length());
            else map.put(level,str.length()-level+dec);
        }
        return ans;
    }
}