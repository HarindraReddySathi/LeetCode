class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int count = nums2.length;
        Stack<Integer> monotonicStack = new Stack<>();
        Map<Integer,Integer> numberToNextGreaterElement = new HashMap<>();
        
        for(int i = count-1; i>=0; i--){

            int cur = nums2[i];

            while(!monotonicStack.isEmpty() && nums2[i]>=monotonicStack.peek()){
                monotonicStack.pop();
            }

            nums2[i] = (monotonicStack.isEmpty()) ?  -1 : monotonicStack.peek();

            numberToNextGreaterElement.put(cur,nums2[i]);

            monotonicStack.push(cur);
        }

        for(int i =0;i<nums1.length;i++){
            nums1[i] = numberToNextGreaterElement.get(nums1[i]);
        }
        return nums1;
    }
}