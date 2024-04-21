class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
        boolean[][][] isVisited = new boolean[m][n][4];
        Queue<int[]> q = new LinkedList<>();

        for(int[] i : guards) {
            isVisited[i[0]][i[1]][0] = true;
            isVisited[i[0]][i[1]][1] = true;
            isVisited[i[0]][i[1]][2] = true;
            isVisited[i[0]][i[1]][3] = true;
            int[] p0 = {i[0],i[1],0};
            q.add(p0);
            int[] p1 = {i[0],i[1],1};
            q.add(p1);
            int[] p2 = {i[0],i[1],2};
            q.add(p2);
            int[] p3 = {i[0],i[1],3};
            q.add(p3);
        }

        for(int[] i : walls) {
            isVisited[i[0]][i[1]][0] = true;
            isVisited[i[0]][i[1]][1] = true;
            isVisited[i[0]][i[1]][2] = true;
            isVisited[i[0]][i[1]][3] = true;
        }
        int ans = m*n - guards.length - walls.length;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                int[] move = dir[cur[2]];
                int x = cur[0]+move[0];
                int y = cur[1]+move[1];
                if(x<0 || x>m-1 || y<0 || y> n-1) continue;
                if(isVisited[x][y][cur[2]]) continue;
                if(!(isVisited[x][y][0] || isVisited[x][y][1] ||isVisited[x][y][2] || isVisited[x][y][3] )) ans--;
                isVisited[x][y][cur[2]] = true;
                int[] push = {x,y,cur[2]};
                q.add(push);
            }
        }
        return ans;
    }
}