class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] map = new boolean[tiles.length()];
        rec(tiles, "", set, map);
        return set.size()-1;
    }
    public void rec(String tiles, String ans, Set<String> set, boolean[] map){
        set.add(ans);
        for(int i=0; i<tiles.length(); i++){
            if(map[i]==false){
                map[i]=true;
                rec(tiles, ans+tiles.charAt(i), set, map);
                map[i]=false;
            }
        }   
    }
}