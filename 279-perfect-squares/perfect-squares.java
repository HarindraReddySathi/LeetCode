class Solution {

    public int numSquares(int n) {
        List<Integer> sq = getSquares(n);
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[n+1];
        isVisited[0]=true;
        q.add(0);
        int level =1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int p=0;p<size;p++){
                int curr = q.poll();
                for(Integer i : sq){
                    if(curr+i==n) return level;
                    if(curr+i>n || isVisited[curr+i])continue;
                    q.add(curr+i);
                    isVisited[curr+i]=true;;
                }
            }
            level++;
        }
        return -1;
    }

    public List<Integer> getSquares(int n){
        int i=1;
        List<Integer> ans = new ArrayList<>();
        while(i*i<=n){
            ans.add(i*i);
            i++;
        }
        return ans;
    }



    /*
    //Recurssive
    public int numSquares(int n) {
        List<Integer> sq = getSquares(n);
        int[] isVisited = new int[n+1];
        squares(n,sq,isVisited);
        if(n>=4)System.out.println(isVisited[1]);
        return isVisited[n];
    }

    public int squares(int n,List<Integer> sq, int[] isVisited ){
        if(n==0) return 0;
        int min =Integer.MAX_VALUE;
        for(Integer i : sq){
            if(i>n) break;
            int k=0;
            if(n-i==0)min=0;
            else if(n-i>0){
                if(isVisited[n-i]==0)k = squares(n-i,sq,isVisited);
                else k = isVisited[n-i];
                min = Math.min(min,k);
            }
        }
        isVisited[n]=min+1;
        return min+1;
    }*/


    /*
    // Iterative
    public int numSquares(int n) {
        List<Integer> sq = getSquares(n);
        int[] ans = new int[n+1];
        ans[0]=0;
        int i =0;
        while(i<n){
            for(Integer s :sq){
                if((i+s<=n)&&(ans[i+s]==0 || (ans[i+s]>ans[i]+1))){
                    ans[i+s]=ans[i]+1;
                    System.out.println(i+s+"-----"+ans[i+s]);
                }
            }
            i++;
        }
        return (ans[n]==0)?-1:ans[n];
    }*/
}