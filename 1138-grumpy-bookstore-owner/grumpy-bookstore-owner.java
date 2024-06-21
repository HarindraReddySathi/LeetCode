class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int ans = 0,res =0;
        int n = customers.length;
        for(int i=0;i<n;i++){
            if(grumpy[i]==0) ans+=customers[i];
        }

        for(int i=0;i<minutes;i++){
            if(grumpy[i]==1) ans+=customers[i];
        }

        res = ans;

        int i=0; int j = minutes;

        while(j<n){
            if(grumpy[i]==1) ans-=customers[i];
            i++;
            if(grumpy[j]==1) ans+=customers[j];
            j++;
            if(ans>res) res = ans;
        } 

        return res;
    }
}