class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left =0,right=n-1;
        int up =0,down =m-1;
        while(left<=right && up<=down){

            for(int j=left;j<=right;j++){
                ans.add(matrix[up][j]);
            }
            up++;
           if(!(left<=right && up<=down)) break;
            for(int i=up;i<=down;i++){
                ans.add(matrix[i][right]);
            }
            right--;
            if(!(left<=right && up<=down)) break;
            for(int j=right;j>=left;j--){
                ans.add(matrix[down][j]);
            }
            down--;
            if(!(left<=right && up<=down)) break;
            for(int i=down;i>=up;i--){
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}