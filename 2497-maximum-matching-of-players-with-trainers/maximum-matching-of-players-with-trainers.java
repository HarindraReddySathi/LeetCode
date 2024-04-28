class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = players.length-1;
        int j = trainers.length-1;
        int ans =0;

        while(i>=0 && j>=0){

            if(trainers[j]>=players[i]){
                i--;j--;
                ans++;
            }else{
                i--;
            }
        }
        return ans;
    }
}