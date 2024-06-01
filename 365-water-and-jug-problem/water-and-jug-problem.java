class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(target==0 || x==target || y==target || x+y == target) return true;

        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited.add(0+"_"+0);
        while(!queue.isEmpty()){
            int[] current = queue.poll();

            //case1  fill second full
            if(current[0]+y==target) return true;
            if(!visited.contains(current[0]+"_"+y)){
                queue.add(new int[]{current[0],y});
                visited.add(current[0]+"_"+y);
            }
            //case2  fill first full
            if(x+current[1]==target) return true;
            if(!visited.contains(x+"_"+current[1])){
                queue.add(new int[]{x,current[1]});
                visited.add(x+"_"+current[1]);
            }
            //case 3 pour water from second to first
                int one = (current[0]+current[1]>x) ? x: current[0]+current[1];
                int second = (current[1]-(one-current[0])>0) ? current[1]-one+current[0] : 0;
                if(one==target || second==target || one+second==target) return true;
                if(!visited.contains(one+"_"+second)){
                    queue.add(new int[]{one,second});
                    visited.add(one+"_"+second);
                }
                if(!visited.contains(one+"_"+0)){
                    queue.add(new int[]{one,0});
                    visited.add(one+"_"+0);
                }
                if(!visited.contains(0+"_"+second)){
                    queue.add(new int[]{0,second});
                    visited.add(0+"_"+second);
                }

            //case 4 pour water from first to second
                second = (current[0]+current[1]>y) ? y: current[0]+current[1];
                one = (current[0]-(second-current[1])>0) ? current[0]-second+current[1] : 0;
                if(one==target || second==target || one+second==target) return true;
                if(!visited.contains(one+"_"+second)){
                    queue.add(new int[]{one,second});
                    visited.add(one+"_"+second);
                }
                if(!visited.contains(one+"_"+0)){
                    queue.add(new int[]{one,0});
                    visited.add(one+"_"+0);
                }
                if(!visited.contains(0+"_"+second)){
                    queue.add(new int[]{0,second});
                    visited.add(0+"_"+second);
                }
        }

        return false;
    }
}