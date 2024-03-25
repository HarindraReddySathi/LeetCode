class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] ans = new long[n];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i],k-> new ArrayList<>()).add(i);
        }
        for(Integer i : map.keySet()){
            int size = map.get(i).size();
            long[] prefix = new long[size];
            long[] suffix = new long[size];
            List<Integer> l = map.get(i);
            for(int j=1;j<size;j++){
                prefix[j]=prefix[j-1]+l.get(j-1);
                //System.out.print(prefix[j]+"#####");
            }
            for(int j=size-2;j>=0;j--){
                suffix[j]=suffix[j+1]+l.get(j+1);
                //System.out.print(suffix[j]+"!!!!!");
            }
            System.out.println();
            for(int j=0;j<size;j++){
                int k = l.get(j);
                //System.out.println(k+"----"+j+"---"+prefix[j]+"---"+suffix[j]);
                ans[k]= (1l*j*k-prefix[j])+(suffix[j]-1l*(size-j-1)*k);
            }
            //System.out.println("----");
        }
        return ans;
    }
}