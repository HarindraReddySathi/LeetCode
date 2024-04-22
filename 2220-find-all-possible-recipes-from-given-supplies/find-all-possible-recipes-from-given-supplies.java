class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Map<String,List<String>> map = new HashMap<>();
        Map<String,Integer> incoming = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        for(String s : supplies){
            List<String> l = new ArrayList<>();
            map.put(s,l);
            q.add(s);
        }
        for(String s : recipes){
            List<String> l = new ArrayList<>();
            map.put(s,l);
        }
        int n = recipes.length;
        for(int i=0;i<n;i++){
            String recipe = recipes[i];
            List<String> ing = ingredients.get(i);
            for(String s : ing){
                map.computeIfAbsent(s,l-> new ArrayList<>()).add(recipe);
                incoming.put(recipe,incoming.getOrDefault(recipe,0)+1);
            }
        }
        List<String> ans = new ArrayList<>();
        while(!q.isEmpty()){
            String cur = q.poll();
            if(!map.containsKey(cur)) continue;
            for(String s : map.get(cur)){
                incoming.put(s,incoming.getOrDefault(s,0)-1);
                if(incoming.get(s)==0){
                    q.add(s);
                    ans.add(s);
                }
            }
        }
        return ans;
    }
}