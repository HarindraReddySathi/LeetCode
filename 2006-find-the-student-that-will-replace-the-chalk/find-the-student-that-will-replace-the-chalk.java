class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        
        long sum = 0;
        int n = chalk.length;
        for(int i=0;i<n;i++){
            sum += chalk[i];
        }
        k = (int)(k%sum);
        sum=0;
        int replaceIdx = -1;
        for(int i=0;i<n;i++){
            sum += chalk[i];
            if(sum > k){
                replaceIdx = i;
                break;
            }
        }
        return replaceIdx;
    }
}