class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        int n = nums1.length;
        for(int i =0;i<n;i++)s1.add(nums1[i]);
        for(int i =0;i<n;i++)s2.add(nums2[i]);
        int n1 = s1.size();
        int n2 = s2.size();
        int common =0;
        for(Integer i : s1){
            if(s2.contains(i)) common++;
        }
        n1-=common;
        n2-=common;
        if(n/2 >n1 && n/2>n2){
            int dec = (n-(n1+n2)>=common)?common:n-(n1+n2);
            return n1+n2+dec;
        }else if(n/2 <= n1 && n/2 <= n2){
            return n;
        }else if(n/2 <= n1 && n/2 > n2){
            int dec = (n/2-(n2)>=common)?common:n/2-(n2);
            return n/2+n2+dec;
        }else{
            int dec = (n/2-(n1)>=common)?common:n/2-(n1);
            return n/2+n1+dec;
        }
    }
}