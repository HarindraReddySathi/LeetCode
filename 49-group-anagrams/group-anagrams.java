class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int[] alpha = new int[26];
        Map<String,List<String>> m = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String s :strs){
            char[] ch = s.toCharArray();
            for(char c :ch){
                alpha[c-'a']++;
            }
            String mapKey = keyCreator(alpha);
            m.computeIfAbsent(mapKey,l -> new ArrayList<>()).add(s);
            Arrays.fill(alpha,0);
        }
        for(String s : m.keySet()){
            ans.add(m.get(s));
        }
        return ans;
    }

    public String keyCreator(int[] alpha){
        StringBuilder sb = new StringBuilder();
        for(int i : alpha){
            sb.append(i+"-");
        }
        return sb.toString();
    }
}