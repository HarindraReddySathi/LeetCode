class Solution {


    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        if(m==1 && n==1) return (matrix[0][0]==target)?true:false;

        int low = 0;
        int high =matrix.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(matrix[mid][0]==target) return true;
            else if(matrix[mid][0]>target) high=mid-1;
            else low =mid+1;
        }
        int i =high;
        if(i==-1) return false;
        low =0;
        high =matrix[0].length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(matrix[i][mid]==target) return true;
            else if(matrix[i][mid]>target) high=mid-1;
            else low =mid+1;
        }
        return false;
    }

    /*public boolean searchMatrix(int[][] matrix, int target) {
        
        int low=0;
        int high = matrix.length-1;
        System.out.println(high);
        int pre=-1;
        while(high>=low){
            int mid = low+(high-low)/2;
            System.out.println(matrix[mid][0]);
            if(matrix[mid][0]==target){
                return true;
            }else if(matrix[mid][0]<target){
                pre=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        if(pre==-1)return false;
        low=0;
        high=matrix[0].length-1;
        while(high>=low){
            int mid = low+(high-low)/2;
            if(matrix[pre][mid]==target){
                return true;
            }else if(matrix[pre][mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }*/
}