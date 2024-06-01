class Solution {
    public boolean canReach(int[] arr, int start) {
        
        if(arr[start]==0) return true;
        int n =arr.length;
        boolean[] isVisited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start]=true;
        while(!queue.isEmpty()){
            int currentIndex = queue.poll();
            int rightNext = currentIndex+arr[currentIndex];
            int leftNext = currentIndex-arr[currentIndex];
            if(rightNext<n && !isVisited[rightNext]){
                if(arr[rightNext]==0) return true;
                isVisited[rightNext] = true;
                queue.add(rightNext);
            }
            if(leftNext>=0 && !isVisited[leftNext]){
                if(arr[leftNext]==0) return true;
                isVisited[leftNext] = true;
                queue.add(leftNext);
            }
        }
        return false;
    }
}