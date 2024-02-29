class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int sum = 0;
		while (startPos[0] != homePos[0]) {
			if (startPos[0] < homePos[0]) {
				sum += rowCosts[++startPos[0]];
			} else {
				sum += rowCosts[--startPos[0]];
			}
		}
		while (startPos[1] != homePos[1]) {
			if (startPos[1] < homePos[1]) {
				sum += colCosts[++startPos[1]];
			} else {
				sum += colCosts[--startPos[1]];
			}
		}
		return sum;
    }
}