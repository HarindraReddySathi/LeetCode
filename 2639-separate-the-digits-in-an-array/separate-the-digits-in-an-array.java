class Solution {
    public int[] separateDigits(int[] nums) {
        int size=0;
        for(int i : nums){
            if(i<10)size++;
            else if(i<100) size+=2;
            else if(i<1000) size+=3;
            else if(i<10000)size+=4;
            else if(i<100000)size+=5;
            else size+=6;
        }
        //System.out.println(size);
        int[] ans = new int[size];
        int cur =0;
        for(int i : nums){
            List<Integer> l = new ArrayList<>();
            while(i>0){
                l.add(i%10);
                i=i/10;
            }
            Collections.reverse(l);
            for(int j : l){
                ans[cur++]=j;
            }
        }
        return ans;
    }
}