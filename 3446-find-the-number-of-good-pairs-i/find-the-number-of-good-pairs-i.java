class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int n1  = nums1.length;
      int n2  = nums2.length;
      for(int i =0;i<n1;i++) nums1[i] = (nums1[i]%k==0) ? nums1[i]/k : -1;
      Map<Integer,Integer> freq = new HashMap<>();
      for(int i : nums2) freq.put(i,freq.getOrDefault(i,0)+1);
      int ans =0;
      for(int i =0;i<n1;i++) System.out.println(nums1[i]);
      for(int i : nums1){
        if(i ==-1) continue;
        int sq = (int)Math.sqrt(i);
        if(i==sq*sq && freq.containsKey(sq)) ans+=freq.get(sq);
        if(i!=sq*sq) sq++;
        for(int j =1;j< sq;j++){
            if(i%j==0){
                if(freq.containsKey(j)) ans+=freq.get(j);
                if(freq.containsKey(i/j)) ans+=freq.get(i/j);
            } 
        }
        //System.out.println(i + " -- "+ans);
      }
      return ans;
    }
}