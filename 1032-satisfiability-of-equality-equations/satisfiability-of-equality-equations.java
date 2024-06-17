class Solution {
    public boolean equationsPossible(String[] equations) {
        
        int[] parent = new int[26];
        int[] size = new int[26];
        Arrays.fill(size,1);
        for(int i=0;i<26;i++) parent[i]=i;
        for(String equation : equations){
            if(!equation.contains("!")){
                int left = findParent(equation.charAt(0)-'a',parent);
                int right = findParent(equation.charAt(3)-'a',parent);
                if(left == right) continue;
                if(size[left]>=size[right]){
                    parent[right] = left;
                    size[left]+=size[right];
                }else{
                    parent[left] = right;
                    size[right]+=size[left];
                }
            }
        }
        for(int i=0;i<26;i++){
            parent[i] = findParent(i,parent);
        }
        for(String equation : equations){
            if(equation.contains("!")){
                int left = equation.charAt(0)-'a';
                int right = equation.charAt(3)-'a';
                if(parent[left]==parent[right]) return false;
            }
        }
        return true;
    }

    public int findParent(int i , int[] parent){
        if(parent[i]!=i){
            parent[i] = findParent(parent[i],parent);
        }
        return parent[i];
    }
}