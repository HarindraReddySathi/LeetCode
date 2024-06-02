class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        boolean[] isVisited = new boolean[n];
        isVisited[0]=true;
        Queue<Integer> queue = new LinkedList<>();
        int count=1;
        queue.addAll(rooms.get(0));
        while(!queue.isEmpty()){
            int curRoom = queue.poll();
            if(isVisited[curRoom]) continue;
            isVisited[curRoom] = true;
            count++;
            if(count==n) return true;
            for(int key : rooms.get(curRoom)){
                if(isVisited[key]) continue;
                queue.add(key);
            }
        }
        return false;
    }
}