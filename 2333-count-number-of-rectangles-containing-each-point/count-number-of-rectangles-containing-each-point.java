class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {

        int[] ans = new int[points.length];
        Arrays.sort(rectangles, Comparator.comparingInt(rectangle -> rectangle[0]));
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] i : rectangles){
            //System.out.println(i[0]+"----"+i[1]);
            map.computeIfAbsent(i[1],l->new ArrayList<>()).add(i[0]);
        }
        for(Integer i : map.keySet()){
            //System.out.println(i +"------"+map.get(i).size());
            //for(int j : map.get(i))System.out.print(j+"--");
            //System.out.println();
        }

        int count =0;
        for(int[] i : points){
            int x = i[0];int y = i[1];
            int temp=0;
            //System.out.println("****######****");
            for(int k : map.keySet()){
                if(k<y) continue;
                //System.out.println("######");
                List<Integer> xPoints = map.get(k);
                int low=0;int high = xPoints.size()-1;
                int cur =-1;
                while(low<=high){
                    int mid = low+(high-low)/2;
                    if(xPoints.get(mid)<x) low = mid+1;
                    else{
                        cur = mid;
                        high = mid-1;
                    }
                }
                if(cur!=-1)temp+=(xPoints.size()-cur);
            }
            ans[count++]=temp;
        }
        return ans;
    }
}