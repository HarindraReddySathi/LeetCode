class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int count=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n-1;i++){
            if(nums[i+1]>nums[i]) sb.append(1);
            else if(nums[i+1] == nums[i]) sb.append(0);
            else sb.append(2);
        }
                StringBuilder sb1 = new StringBuilder();

        for(int j=0;j<m;j++){
            if(pattern[j]!=-1)sb1.append(pattern[j]);
            else sb1.append(2);
        }
                        System.out.println(sb.toString());
        int curr = 0;
        while(curr != -1) {
            int idx = sb.toString().indexOf(sb1.toString(), curr);
            if(idx == -1) break;
            else {
                System.out.println(idx);
                count++;
                curr = idx+1;
            }
        }
        return count;
            //return StringUtils.countMatches(sb.toString(), sb1.toString());

    }
}