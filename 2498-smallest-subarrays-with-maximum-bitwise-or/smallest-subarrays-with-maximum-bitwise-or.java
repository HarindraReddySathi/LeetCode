class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] bitCount = new int[32];
        int n = nums.length;
        int[] ans = new int[n];
        int count= 0;
        for(int i=0;i<n;i++){
            int num = nums[i];
            for(int j=0;j<32;j++){
                int dec = num & 1;
                if(dec== 1 && bitCount[j]==0) count++;
                bitCount[j]+=dec;
                num=num>>1;
            }
        }
        int k=0;
        int cur = 0;
        int[] setCount = new int[32];
        for(int i=0;i<n;i++) {
            if(count==0){
                //System.out.println("*****");
                ans[i]=1;
                continue;
            }
            while(cur < count) {
                int num = nums[k];
                for(int j=0;j<32;j++){
                    int dec = num & 1;
                    if(setCount[j] == 0 && dec ==1) cur++;
                    setCount[j]+=dec;
                    num=num>>1;
                }
                /*for(int j=0;j<32;j++){
                    System.out.print(setCount[j] + " ");
                }*/
                //System.out.println();
                //System.out.println(cur);
                k++;
            }
            //System.out.println(k + " ---- " + i);
            ans[i]=k-i;
            int num = nums[i];
            for(int j=0;j<32;j++){
                int dec = num & 1;
                setCount[j]-= dec;
                bitCount[j]-= dec;
                if(setCount[j] == 0 && dec==1) cur--;
                if(bitCount[j] == 0 && dec==1) count--;
                //System.out.println(count);
                num=num>>1;
            }
        }
        return ans;

    }
}