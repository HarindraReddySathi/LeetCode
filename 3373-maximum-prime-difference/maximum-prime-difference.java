class Solution {
    public int maximumPrimeDifference(int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.add(2);set.add(13);set.add(31);set.add(53);set.add(73);
        set.add(3);set.add(17);set.add(37);set.add(59);set.add(79);
        set.add(5);set.add(19);set.add(41);set.add(61);set.add(83);
        set.add(7);set.add(23);set.add(43);set.add(67);set.add(89);
        set.add(11);set.add(29);set.add(47);set.add(71);set.add(97);

        int cur =0;
        int[] dif = {-1,-1};

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                if(cur==0){
                    dif[cur++]=i;
                }else{
                    dif[cur]=i;
                }
            }
        }
        if(dif[1]==-1) return 0;
        else return dif[1]-dif[0];
    }
}