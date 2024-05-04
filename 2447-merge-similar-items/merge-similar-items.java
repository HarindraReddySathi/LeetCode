class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        
        int n1 = items1.length;
        int n2 = items2.length;
        int[] check = new int[1001];
        for(int[] i : items1)check[i[0]]+=i[1];
        for(int[] i : items2)check[i[0]]+=i[1];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =1;i<=1000;i++){
            if(check[i]==0)continue;
            List<Integer> l = new ArrayList<>();
            l.add(i);l.add(check[i]);
            ans.add(l);
        }
        return ans;
    }
}