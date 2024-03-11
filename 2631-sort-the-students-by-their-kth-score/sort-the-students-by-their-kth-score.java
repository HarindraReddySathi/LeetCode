class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        
        int m = score.length;
        int n = score[0].length;
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<m;i++){
            List<Integer> p = new ArrayList<>();
            for(int j=0;j<n;j++){
                p.add(score[i][j]);
            }
            l.add(p);
        }
        Comparator<List<Integer>> c = new Comparator<>(){
            public int compare(List<Integer> l1,List<Integer> l2){
                return -1*Integer.compare(l1.get(k), l2.get(k)); 
            }
        };
        Collections.sort(l,c);
        int i=0,j=0;
        for(List<Integer> x :l){
            j=0;
            for(Integer d : x){
                score[i][j]=d;
                j++;
            }
            i++;
        }
        return score;
    }
}