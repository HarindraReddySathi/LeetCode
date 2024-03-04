class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        //int ans = Integer.MIN_VALUE;
        int score =0;
        int i =0;
        int j = n-1;
        while(i<=j){

            if(tokens[i]<=power){
                power-=tokens[i];
                score++;
                //if(ans<score) ans =score;
                i++;
            }else{
                if(score>0 && i!=j){
                    power+=tokens[j];
                    //if(ans<score) ans =score;
                    score--;
                    j--;
                }else{
                    break;
                }
            }
        }
        return score;
    }
}