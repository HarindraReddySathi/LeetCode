class Solution {
    public List<String> commonChars(String[] words) {
        
        Map<Character,Integer> main = new HashMap<>();
        
        for(int i=0;i<words.length;i++){
            char[] ch = words[i].toCharArray();
            if(i==0){
                for(char c : ch)
                    main.put(c,main.getOrDefault(c,0)+1);
            }else{
                Map<Character,Integer> temp = new HashMap<>();
                for(char c : ch)
                    temp.put(c,temp.getOrDefault(c,0)+1);
                for(Character c : main.keySet()){
                    if(temp.containsKey(c)){
                        main.put(c,Math.min(temp.get(c),main.get(c)));
                    }else{
                        main.put(c,0);
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(Character c : main.keySet()){
            for(int i=0;i<main.get(c);i++)ans.add(c+"");
        }
        return ans;
    }
}