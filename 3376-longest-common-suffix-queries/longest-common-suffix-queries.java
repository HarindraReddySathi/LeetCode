class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsQuery.length;
        int m = wordsContainer.length;
        int[] ans = new int[n];
        Trie dummy = new Trie();
        for(int i=0;i<m;i++){
            char[] ch = wordsContainer[i].toCharArray();
            if(dummy.min>ch.length){
                dummy.min=ch.length;
                dummy.pos=i;
            }
            dummy.add(ch,0,i,ch.length);
        }
        for(int i=0;i<n;i++){
            char[] ch = wordsQuery[i].toCharArray();
            int p = dummy.pos;
            if(dummy.child[ch[ch.length-1]-'a']!=null) p = dummy.search(ch,0,ch.length);
            ans[i]=p;
        }
        return ans;
    }

    class Trie{
        int min = Integer.MAX_VALUE;
        int pos =-1;
        Trie[] child = new Trie[26];

        public void add(char[] ch,int level,int i,int n){
            if(level==ch.length) return;
            int cur = (int)(ch[n-1-level]-'a');
            if(child[cur]==null)child[cur] = new Trie();
            if(ch.length<child[cur].min){
                //System.out.println(cur);
                child[cur].min=ch.length;
                child[cur].pos=i;
            }
            //System.out.println(n+"--"+ch[n-1-level]+"--"+child[cur].min+"---"+child[cur].pos);
            child[cur].add(ch,level+1,i,n);
        }

        public int search(char[] ch,int level,int n){
            if(level==ch.length) return pos;
            int cur = (int)(ch[n-1-level]-'a');
            if(child[cur]==null) return pos;
            return child[cur].search(ch,level+1,n);
        }
    }
}