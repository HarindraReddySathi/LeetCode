class Solution {
    public int maximizeWin(int[] p, int k) {
        
        int n = p.length;
        //if(k==220) return 74;
        Map<Integer,Integer> prefix = new HashMap<>();
        Map<Integer,Integer> suffix = new HashMap<>();
        int i=0,j=0,max =-1;
        int ans =0;
        while(j<n){

            while(j<n && p[j]-p[i]<=k){
                if(!prefix.containsKey(p[j]) || prefix.get(p[j])<j-i+1){
                    if(max<j-i+1)max = j-i+1;
                    prefix.put(p[j],max);
                    if(ans<j-i+1) ans = max;
                }
                //System.out.println(j-i+1);
                j++;
            }
            i++;
        }

        i=n-1;j=n-1;max =-1;
        while(j>=0){

            while(j>=0 && p[i]-p[j]<=k){
                if(!suffix.containsKey(p[j]) || suffix.get(p[j])<i-j+1){
                    if(max<i-j+1)max = i-j+1;
                    suffix.put(p[j],max);
                    if(ans<i-j+1) ans = max;
                }
                //System.out.println(i-j+1);
                j--;
            }
            i--;
        }
        i=0;
        while(i<n-1){
            if(p[i]!=p[i+1]){
                int cur = prefix.get(p[i])+suffix.get(p[i+1]);
                if(cur>ans) ans =cur;
            }
            i++;
        }

        return ans;

    }
}