import java.util.Arrays;

class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        int n = power.length;
        if (n == 1) {
            return power[0];
        }
        if (n == 2) {
            return (power[1] - power[0] <= 2 && power[1] != power[0]) ? power[1] : power[0] + power[1];
        }

        Map<Integer,Integer> freqMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int i : power){
            freqMap.put(i,freqMap.getOrDefault(i,0)+1);
        }

        long[] dp = new long[n];
        dp[0] = 1l*power[0]*freqMap.get(power[0]);
        set.add(power[0]);
        if(!set.contains(power[1])){
            dp[1] = 1l*power[1]*freqMap.get(power[1]);
            dp[1] += (power[1] - power[0] <= 2) ?  0 : power[0];
            //System.out.println(dp[1]+"****");
        }else{
            dp[1] = dp[0];
        }

        System.out.println(dp[0]);
        System.out.println(dp[1]);

        for (int i = 2; i < n; i++) {
            if(!set.contains(power[i])){
                int rightExtremePos = findMaxPosition(power[i] - 3, power);
                long prev = (rightExtremePos == -1) ? 0 : dp[rightExtremePos];
                dp[i] = Math.max(dp[i - 1], prev + 1l*power[i]*freqMap.get(power[i]));
            }else{
                dp[i] = dp[i-1];
            }
            System.out.println(dp[i]);
        }
        return dp[n - 1];
    }

    private int findMaxPosition(int key, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int rightExtreme = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
                rightExtreme = mid;
            }
        }
        return rightExtreme;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] power = {1, 3, 5, 2, 4, 6};
        System.out.println(sol.maximumTotalDamage(power)); // Example usage
    }
}
