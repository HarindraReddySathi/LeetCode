class Solution {
    public List<Integer> getRow(int rowIndex) {
       int numRows = rowIndex+1;
       List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            if(i==0)temp.add(1);
            else{
                List<Integer> prev = ans.get(i-1);
                for(int j=0;j<=i;j++){
                    if(j==0 || j==i)temp.add(1);
                    else{
                       temp.add(prev.get(j-1)+prev.get(j));
                    }
                }
            }
            ans.add(temp);
        }
        return ans.get(ans.size()-1);
    }
}