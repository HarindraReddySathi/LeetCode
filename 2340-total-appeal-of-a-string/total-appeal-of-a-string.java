class Solution {
    public long appealSum(String s) {
        
        char[] ch = s.toCharArray();
        int n = ch.length;
        Map<Character,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(ch[i],p-> new ArrayList<>()).add(i);
        }
        long ans =0;
        for(Character c : map.keySet()){
            int start = map.get(c).get(0);
            for(Integer i : map.get(c)){
                ans+=1l*(i+1);
                ans+=1l*(i-start)*(start);
                System.out.println((2*i+1-start));
                start=i+1;
            }
            int k = map.get(c).get(map.get(c).size()-1);
            //System.out.println((n-1-k)*(k+1));
            ans+=1l*(n-1-k)*(k+1);
        }
        return ans;
    }
}