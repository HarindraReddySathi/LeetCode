class Solution {
    public int minCostConnectPoints(int[][] points) {
        int pointsCount = points.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.edgeLength-b.edgeLength);
        for(int i=0;i<pointsCount;i++){
            for(int j=0;j<i;j++){
                int edgeLength = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                pq.add(new Node(edgeLength,i,j));
            }
        }

        int[] parent = new int[pointsCount];
        for(int i=0;i<pointsCount;i++) parent[i]=i;
        int[] size = new int[pointsCount];
        Arrays.fill(size,1);
        int minCost =0;
        while(!pq.isEmpty()){
            Node currNode = pq.poll();

            int left = currNode.start;
            int right = currNode.end;

            while(parent[left]!=left){
                parent[left] = parent[parent[left]];
                left = parent[left];
            }

            while(parent[right]!=right){
                parent[right] = parent[parent[right]];
                right = parent[right];
            }

            if(left==right) continue;

            if(size[left]>=size[right]){
                parent[right]=left;
                size[left]+=size[right];
            }else{
                parent[left]=right;
                size[right]+=size[left];
            }
            minCost+=currNode.edgeLength;
        }
        return minCost;
    }

    public class Node {
        
        int edgeLength ;
        int start;
        int end;

        public Node(int edgeLength,int start,int end){
            this.edgeLength=edgeLength;
            this.start=start;
            this.end=end;
        }

    }
}