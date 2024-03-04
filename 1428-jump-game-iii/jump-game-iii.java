class Solution {
    public boolean canReach(int[] arr, int start) {
       if(arr[start]==0) return true;
       int n = arr.length;
       int[] isVisited = new int[n];
       int dec = isPossible(arr,isVisited,start,n);
       if(dec==1) return true;
       return false;
    }

    public int isPossible(int[] arr,int[] isVisited,int start,int n){

        if(isVisited[start]==1) return 1;
        if(isVisited[start]==2) return -1;
        if(arr[start]==0){
            isVisited[start]=1;
            return 1;
        }
        isVisited[start]=2;
        int left =0,right=0;
        if(start+arr[start]<n)
            left = isPossible(arr,isVisited,start+arr[start],n);
        if(left==1)isVisited[start]=1;
        if(left==1) return 1;
        if(start-arr[start]>=0)
            right = isPossible(arr,isVisited,start-arr[start],n);
        if(right==1)isVisited[start]=1;
        if(right==1) return 1;
        isVisited[start]=-1;
        return -1;
        
    }
}