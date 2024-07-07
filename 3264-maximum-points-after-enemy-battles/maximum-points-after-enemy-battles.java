class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        
        int enemyCount = enemyEnergies.length;
        long pointsEarned =0;

        Arrays.sort(enemyEnergies);

        if(currentEnergy<enemyEnergies[0]) return pointsEarned;

        long curEnergy = currentEnergy;

        int j = enemyCount-1;

        while(j>=0){

            pointsEarned += (curEnergy/enemyEnergies[0]);

            curEnergy = (curEnergy%enemyEnergies[0]);

            curEnergy += enemyEnergies[j--];
        }

        return pointsEarned;
    }
}