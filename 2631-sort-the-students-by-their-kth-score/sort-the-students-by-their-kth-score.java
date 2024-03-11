class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {

        int m = score.length;
        int n = score[0].length;
        Comparator<int[]> c = new Comparator<>(){
            public int compare(int[] l1,int[] l2){
                return -1*Integer.compare(l1[k], l2[k]); 
            }
        };
        Arrays.sort(score,c);
        return score;
    }
}