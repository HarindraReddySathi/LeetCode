class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int i=0;i<n;i++){
            adjList.computeIfAbsent(manager[i],l-> new ArrayList<>()).add(i);
        }

        return DFS(adjList,headID,informTime,n,0);
    }


    public int DFS(Map<Integer,List<Integer>> adjList,int headID,int[] informTime,int n,int curTime){

        if(!adjList.containsKey(headID)) return curTime;
        int maxInformTime =0;
        for(int subOrdinate : adjList.get(headID)){
            int inform = DFS(adjList,subOrdinate,informTime,n,curTime+informTime[headID]);
            if(maxInformTime<inform)maxInformTime=inform;
        }
        return maxInformTime;
    }

}