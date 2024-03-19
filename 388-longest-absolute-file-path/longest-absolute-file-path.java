class Solution {
    public int lengthLongestPath(String input) {
        Map<Integer,Integer> map = new HashMap<>();
        String[] s = input.split("\n");
        int ans =0;
        //map.put(0,s[0].length());
        for(String str : s){
            //if(str.equals(s[0]))continue;
            String[] p = str.split("\t");
            int level =p.length-1;
            if(str.contains(".")){
                int dec = (level ==0)?0:map.get(level-1);
                int cur = dec+str.length();
                if(cur>ans)ans =cur;
            }else{
                int dec = (level ==0)?0:map.get(level-1);
                map.put(level,str.length()-level+dec);
            }
        }
        return ans;
    }
}