class Solution {
    
    Comparator<int[]> comp = new Comparator<>(){
        public int compare(int[] a ,int[] b){
            if(a[0]!=b[0]) return a[0]-b[0];
            else{
                if(a[1]!=b[1]) return a[1]-b[1];
                else return a[2]-b[2];
            }
        }
    };
    Comparator<int[]> comp1 = new Comparator<>(){

        public int compare(int[] a ,int[] b){
            if(a[0]!=b[0]) return a[0]-b[0];
            else return a[1]-b[1];
        }
    };
    public int[] getOrder(int[][] tasks) {
        
        int n = tasks.length;
        int[] ans = new int[n];
        int pos =1;
        int[][] t = new int[n][3];
        for(int i =0;i<n;i++){
            t[i][0]=tasks[i][0];
            t[i][1]=tasks[i][1];
            t[i][2]=i;
        }
        Arrays.sort(t,comp);

        /*for(int i =0;i<n;i++){
            System.out.println(t[i][0] +" -- "+t[i][1]+" -- "+t[i][2]);
        }*/


        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comp1);
        int dead =t[0][0]+t[0][1];
        ans[0]=t[0][2];


        for(int i =1;i<n;i++){
            
            if(t[i][0]< dead){
                minHeap.add(new int[]{t[i][1],t[i][2]});
                continue;
            }else if(t[i][0]==dead){
                minHeap.add(new int[]{t[i][1],t[i][2]});
                int[] mini = minHeap.poll();
                ans[pos++] = mini[1];
                dead+=mini[0]; 
            }else{

                while(!minHeap.isEmpty() && dead<t[i][0]){
                    int[] mini = minHeap.poll();
                    ans[pos++] = mini[1];
                    dead+=mini[0]; 
                }
                if(minHeap.isEmpty()){
                    dead =t[i][0]+t[i][1];
                    ans[pos++]=t[i][2];
                    continue;
                }
                if(dead==t[i][0]){
                    minHeap.add(new int[]{t[i][1],t[i][2]});
                    int[] mini = minHeap.poll();
                    ans[pos++] = mini[1];
                    dead+=mini[0]; 
                }else if(dead>t[i][0]){
                    minHeap.add(new int[]{t[i][1],t[i][2]});
                }
            }
        }

        while(!minHeap.isEmpty()){
            int[] mini = minHeap.poll();
            ans[pos++] = mini[1];
        }

        return ans;
    }
}