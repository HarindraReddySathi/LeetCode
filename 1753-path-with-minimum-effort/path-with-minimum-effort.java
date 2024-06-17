class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int[][] directions = {{0,1},{1,0}};
        int rows = heights.length;
        int columns = heights[0].length;
        if(rows ==1 && columns ==1) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        // Add all edges to the priority queue
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                for(int[] direction : directions){
                    int x = i + direction[0];
                    int y = j + direction[1];
                    if(x < 0 || y < 0 || x >= rows || y >= columns) continue;
                    int effort = Math.abs(heights[i][j] - heights[x][y]);
                    pq.add(new int[]{effort, i, j, x, y});
                }
            }
        }

        Parent[][] parent = new Parent[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                parent[i][j] = new Parent(i, j, 1);
            }
        }

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            Parent left = findParent(current[1], current[2], parent);
            Parent right = findParent(current[3], current[4], parent);

            if(!left.equals(right)){
                if(left.size >= right.size){
                    left.size += right.size;
                    parent[right.x][right.y] = left;
                }else{
                    right.size += left.size;
                    parent[left.x][left.y] = right;
                }
            }

            if(findParent(0, 0, parent).equals(findParent(rows - 1, columns - 1, parent))) {
                return current[0];
            }
        }

        return -1;
    }

    public Parent findParent(int i, int j, Parent[][] parent){
        if(parent[i][j].x != i || parent[i][j].y != j){
            Parent rootParent = findParent(parent[i][j].x, parent[i][j].y, parent);
            parent[i][j] = rootParent; // Path compression
        }
        return parent[i][j];
    }

    class Parent {
        int x;
        int y;
        int size;

        public Parent(int x, int y, int size){
            this.x = x;
            this.y = y;
            this.size = size;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Parent parent = (Parent) obj;
            return x == parent.x && y == parent.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}