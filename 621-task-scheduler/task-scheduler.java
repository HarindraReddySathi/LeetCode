class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] alpha = new int[26];
        int max =0;
        int mc =0;
        int sum=tasks.length;
        for(char c : tasks){
            alpha[c-'A']++;
            if(alpha[c-'A']>max){
                max = alpha[c-'A'];
                mc=1;
            }else if(alpha[c-'A']==max){
                mc++;
            }
        }
        sum-=(max*mc);
        //System.out.println(max+"--"+mc+"---"+sum+"--"+del);
        int idle = (max-1)*n;
        idle = (idle-(max-1)*(mc-1)>0)?idle-(max-1)*(mc-1):0;
        idle = (sum>idle)?sum:idle;
        int ans = max*mc+idle;
        return ans;
    }
}