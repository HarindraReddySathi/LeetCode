class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int[] cookieDec = new int[n];
        Arrays.fill(cookieDec,-1);
        int emptychild = k;
        int[] child = new int[k];
        int[] ans = new int[1];
        ans[0]=Integer.MAX_VALUE;
        DFS(cookies,cookieDec,emptychild,child,ans,k,n,0);
        return ans[0];
    }

    public void DFS(int[] cookies,int[] cookieDec,int emptychild,int[] child,int[] ans,int k,int n,int level){

        if(level==n){
            unfairnessCalculation(cookies,cookieDec,ans,k);
            return ;
        }
        
       

        for(int i=0;i<k;i++){
            cookieDec[level]=i;
            if(child[i]==0)emptychild--;
            child[i]++;
            if(!(emptychild>n-level-1))
            DFS(cookies,cookieDec,emptychild,child,ans,k,n,level+1);
            cookieDec[level]=-1;
            child[i]--;
            if(child[i]==0)emptychild++;
        }
    }

    public void unfairnessCalculation(int[] cookies,int[] cookieDec,int[] ans,int k){

        int[] temp = new int[k];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<cookies.length;i++){
            temp[cookieDec[i]]+=cookies[i];
        }
        for(int i=0;i<k;i++){
            if(temp[i]>max)max=temp[i];
        }
        if(max<ans[0])ans[0]=max;
    }
}