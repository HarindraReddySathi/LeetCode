import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        // Maps to keep track of the current color at each position and count of positions for each color
        Map<Integer, Integer> posColor = new HashMap<>();
        Map<Integer, Integer> colorPosCount = new HashMap<>();
        int[] ans = new int[queries.length];
        int pos = 0;
        int distinctColorsCount = 0;
        
        for (int[] query : queries) {
            int x = query[0]; // position
            int y = query[1]; // color
            
            // If the position x already has a color
            if (posColor.containsKey(x)) {
                int oldColor = posColor.get(x);
                colorPosCount.put(oldColor, colorPosCount.get(oldColor) - 1);
                
                // If the old color count drops to zero, reduce the distinct color count
                if (colorPosCount.get(oldColor) == 0) {
                    distinctColorsCount--;
                }
            }
            
            // Update the position with the new color
            posColor.put(x, y);
            
            // Update the count of positions for the new color
            if (colorPosCount.containsKey(y) && colorPosCount.get(y)!=0) {
                colorPosCount.put(y, colorPosCount.get(y) + 1);
            } else {
                colorPosCount.put(y, 1);
                distinctColorsCount++;
            }
            
            // Record the number of distinct colors after this query
            ans[pos++] = distinctColorsCount;
        }
        
        return ans;
    }
}
