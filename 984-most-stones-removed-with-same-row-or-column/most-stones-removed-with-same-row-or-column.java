class Solution {
    public int removeStones(int[][] stones) {
        
        int numberOfStones = stones.length;
        List<int[]> connectedStones = findConnectedStones(stones,numberOfStones);
        int[] rootStone = new int[numberOfStones];
        for(int i=0;i<numberOfStones;i++) rootStone[i]=i;
        int[] clusterSize = new int[numberOfStones];
        Arrays.fill(clusterSize,1);

        for(int[] edge : connectedStones){
            int left = findRoot(rootStone,edge[0]);
            int right = findRoot(rootStone,edge[1]);

            if(left==right) continue;

            if(clusterSize[left]>=clusterSize[right]){
                rootStone[right]=left;
                clusterSize[left]+=clusterSize[right];
            }else{
                rootStone[left]=right;
                clusterSize[right]+=clusterSize[left];
            }
        }
        int clusterCount =0;
        for(int i=0;i<numberOfStones;i++){
            if(rootStone[i]==i) clusterCount++;
        }
        return numberOfStones-clusterCount;
    }

    public int findRoot(int[] rootStone,int stone){

        if(rootStone[stone]!=stone){
            rootStone[stone] = findRoot(rootStone,rootStone[stone]);
        }
        return rootStone[stone];
    }

    public List<int[]> findConnectedStones(int[][] stones,int numberOfStones){

        List<int[]> connectedStones = new ArrayList<>();

        for(int i=0;i<numberOfStones;i++){
            for(int j=i+1;j<numberOfStones;j++){
                if(isConnectedStones(stones[i],stones[j])){
                    connectedStones.add(new int[]{i,j});
                }
            }
        }
        return connectedStones;
    }

    public boolean isConnectedStones(int[] firstStone ,int[] secondStone){

        if(firstStone[0]==secondStone[0] || firstStone[1]==secondStone[1]) return true;
        return false;
    }
}