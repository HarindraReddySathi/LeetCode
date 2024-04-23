class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
         int[] incoming = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            map.computeIfAbsent(prerequisite[1], l -> new ArrayList<>()).add(prerequisite[0]);
            incoming[prerequisite[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (incoming[i] == 0) {
                queue.add(i);
            }
        }
        
        int count = 0; // Tracks the number of courses processed
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++; // Increment processed courses
            if (!map.containsKey(current)) continue;
            for (int nextCourse : map.get(current)) {
                incoming[nextCourse]--;
                if (incoming[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }
        
        return count == numCourses;
    }
}