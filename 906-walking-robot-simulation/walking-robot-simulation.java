class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int n = commands.length;
        int m = obstacles.length;
        int[] pos = new int[2];
        int[][] dir = {{0,1}, {-1,0},{0,-1}, {1,0}};
        int cur = 0;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<m;i++){
            map.computeIfAbsent(obstacles[i][0],l -> new HashSet<>()).add(obstacles[i][1]);
        }
        for(int i=0;i<n;i++) {
            if(commands[i] == -1) {
                if(cur-1<0) cur = 3;
                else cur--;
            }
            else if(commands[i] == -2) {
                if(cur+1>3) cur = 0;
                else cur++;
            }
            else {
                int x = dir[cur][0];
                int y = dir[cur][1];

                for(int j=0;j<commands[i];j++) {
                    pos[0]+=x;
                    pos[1]+=y;
                    if(map.containsKey(pos[0]) && map.get(pos[0]).contains(pos[1])) {
                        pos[0]-=x;
                        pos[1]-=y;
                        break;
                    }

                }
                res = Math.max(res, (pos[0]*pos[0]+pos[1]*pos[1]));
            }

            //System.out.println(pos[0]+" -- " + pos[1]);
        }

        return res;
    }
}