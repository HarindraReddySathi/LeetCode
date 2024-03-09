class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for(int i : nums1){
            s.add(i);
        }
        for(int i : nums2){
            if(s.contains(i)) return i;
        }
        return -1;
    }
}