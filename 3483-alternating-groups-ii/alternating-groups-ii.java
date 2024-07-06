class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        
        int n = colors.length;
        int j=1,size=1,ans=0;

        for(int i=0;i<n;i++){

            while(size<k && isAlternatingColor(colors,n,j)) {
                size++;
                j= (j+1)%n;
            }

            if(size==k){
                //if(colors[j]!=colors[i]) ans++;
                ans++;
                size--;
            }else if(!isAlternatingColor(colors,n,j)){
                if(j<i) break;
                i=j-1;
                j= (j+1)%n;
                size=1;
            }
        }

        return ans;
    }

    private boolean isAlternatingColor(int[]colors, int n,int j){
        if((j==0 && colors[j]!=colors[n-1])||(j!=0 &&colors[j]!=colors[j-1])) return true;
        return false;
    }
}