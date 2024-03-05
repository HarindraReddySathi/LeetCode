class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n2;i++){
            map.put(nums2[i],i);
        }
        nextElementGreater(nums2,n2);
        for(int i=0;i<n1;i++){
            nums1[i]= nums2[map.get(nums1[i])];
        }
        return nums1;
    }

    public void nextElementGreater(int[] nums,int n){
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        for(int i=n-1;i>=0;i--){
            int p = nums[i];
            while(!s.isEmpty() && nums[i]>s.peek()){
                s.pop();
            }
            if(s.isEmpty()) nums[i]=-1;
            else{
                nums[i]=s.peek();
            }
            s.push(p);
            //System.out.println( nums[i]);
        }
    }
}