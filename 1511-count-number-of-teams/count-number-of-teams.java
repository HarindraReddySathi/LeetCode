class Solution {
    public int numTeams(int[] rating) {
        
        int n = rating.length;
        Node largerDummy = new Node(-1);
        Node smallerDummy = new Node(-1);
        int[] poh = new int[n];
        int[] pol = new int[n];
        int[] prh = new int[n];
        int[] prl = new int[n];
        for(int i=n-1;i>=0;i--){
            poh[i]= largerDummy.greaterCount(rating[i],31);
            pol[i]= largerDummy.lesserCount(rating[i],31);
            //System.out.println(post[i]);
            largerDummy.add(rating[i],31);
        }
        System.out.println("****");
        for(int i=0;i<n;i++){
            prh[i]= smallerDummy.greaterCount(rating[i],31);
            prl[i]= smallerDummy.lesserCount(rating[i],31);
            //System.out.println(pre[i]);
            smallerDummy.add(rating[i],31);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans+=poh[i]*prl[i];
            ans+=pol[i]*prh[i];
        }
        return ans;
    }

    class Node{
        int val;
        Node[] child = new Node[2];
        int[] childCount = new int[2];

        public Node(int val){
            this.val=val;
        }

        public void add(int i,int level){
            if(level==0) return;
            int p = i;
            p >>= (level-1);
            int curBit = p%2;
            if(child[curBit]==null)child[curBit] = new Node(curBit);
            childCount[curBit]++;
            child[curBit].add(i,level-1);
        }

        public int greaterCount(int i,int level){
            if(level==0) return 0;
            int p = i;
            p >>= (level-1);
            int curBit = p%2;
            int ans =0;
            if(curBit==0) ans+=childCount[1];
            if(child[curBit]!=null)ans+=child[curBit].greaterCount(i,level-1);
            return ans;
        }
        public int lesserCount(int i,int level){
            if(level==0) return 0;
            int p = i;
            p >>= (level-1);
            int curBit = p%2;
            int ans =0;
            if(curBit==1) ans+=childCount[0];
            if(child[curBit]!=null)ans+=child[curBit].lesserCount(i,level-1);
            return ans;
        }
    }
}