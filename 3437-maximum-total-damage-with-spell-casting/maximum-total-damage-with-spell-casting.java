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
        for(int i : power){
            freqMap.put(i,freqMap.getOrDefault(i,0)+1);
        }

        Map<Integer,Long> map = new HashMap<>();
        long maxDamage = 0l;

        map.put(power[0],1l*power[0]*freqMap.get(power[0]));
        //System.out.println(power[0]+" -- "+map.get(power[0]));
        if(!map.containsKey(power[1])){
            long val = 1l*power[1]*freqMap.get(power[1]);
            val += (power[1] - power[0] <= 2) ?  0 : map.get(power[0]);
            map.put(power[1],val);
            //System.out.println(power[1]+" -- "+map.get(power[1]));
        }
        maxDamage = map.get(power[1]);

        for (int i = 2; i < n; i++) {
            if(!map.containsKey(power[i])){
                int rightExtremePos = findMaxPosition(power[i] - 3, power);
                long prev = (rightExtremePos == -1) ? 0 : map.get(power[rightExtremePos]);
                long val = prev + 1l*power[i]*freqMap.get(power[i]);
                if(maxDamage<val) maxDamage = val;
                map.put(power[i],maxDamage);
                //System.out.println(power[i]+" -- "+map.get(power[i]));
            }
        }
        return maxDamage;
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
