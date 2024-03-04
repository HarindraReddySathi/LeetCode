class Solution {
    public boolean circularArrayLoop(int[] arr) {
        
        int n = arr.length;
        int[] nums = new int[n];
        for(int i =0;i<n;i++){
            if(arr[i]>0) nums[i]=(i+arr[i])%n;
            else nums[i] = n-1-(n-i-1+Math.abs(arr[i]))%n;
        }
        int[] isVisited = new int[n];
        int[] count = new int[1];
        for(int i=0;i<n;i++){
            if(isVisited[i]==0 && isCyclePresent(isVisited,i,count,nums,n,arr)) return true;
        }
        return false;
        
    }

    public boolean isCyclePresent(int[] isVisited,int i,int[] count,int[] nums,int n,int[] arr){
        isVisited[i]=1;
        count[0]++; 
        int hare =nums[i];
        int tortoise = nums[i];
        while(count[0]<n){
            hare = nums[nums[hare]];
            tortoise = nums[tortoise];
            if(isVisited[tortoise]==0)count[0]++;
            isVisited[tortoise]++;
            if(hare==tortoise){
                if(nums[hare]==hare) return false;
                return checkNegative(arr,hare,nums);
            }
        }
        return false;
    }

    public boolean checkNegative(int[] arr,int i,int[] nums){
        
        int dec = (arr[i]<0) ?-1:1;
        int t = nums[i];
        while(t!=i){
            if(arr[t]*dec<0) return false;
            t = nums[t];
        }
        return true;
    }
    
}