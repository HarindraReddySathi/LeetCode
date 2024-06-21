class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int low = 1;
        int high = Integer.MIN_VALUE;
        
        // Find the maximum quantity in the array
        for (int i = 0; i < m; i++) {
            if (quantities[i] > high) {
                high = quantities[i];
            }
        }
        
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(mid, quantities, n)) {
                ans = mid; // mid is a possible answer, try to find a smaller one
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    public boolean isPossible(int mid, int[] quantities, int n) {
        int requiredItems = 0;
        
        for (int quantity : quantities) {
            requiredItems += Math.ceil((double) quantity / mid); // ceil(i / mid) is the number of items needed for quantity i
        }
        
        return requiredItems <= n;
    }
}
