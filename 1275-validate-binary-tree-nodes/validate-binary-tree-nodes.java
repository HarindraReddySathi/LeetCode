class Solution {
    public boolean validateBinaryTreeNodes(int no, int[] leftChild, int[] rightChild) {
       
       boolean[] isVisited = new boolean[no];
       int[] incoming = new int[no];
       for(int i =0;i<no;i++){
            if(leftChild[i]!=-1){
                incoming[leftChild[i]]++;
                if(incoming[leftChild[i]]>1) return false;
            }
            if(rightChild[i]!=-1){
                incoming[rightChild[i]]++;
                if(incoming[rightChild[i]]>1) return false;
            }
       }
       int start =-1;
       for(int i =0;i<no;i++){
            if(incoming[i]==0){
                start =i;
                break;
            }
       }
       if(start==-1) return false;
       Queue<Integer> q = new LinkedList<>();
       q.add(start);
       no--;
       isVisited[start]=true;
       while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int cur = q.poll();
                if(leftChild[cur]!=-1){
                    if(isVisited[leftChild[cur]]) return false;
                    q.add(leftChild[cur]);
                    no--;
                    isVisited[leftChild[cur]] = true;
                }
                if(rightChild[cur]!=-1){
                    if(isVisited[rightChild[cur]]) return false;
                    q.add(rightChild[cur]);
                    no--;
                    isVisited[rightChild[cur]] = true;
                }
            }
       }
       return no==0;
    }
}