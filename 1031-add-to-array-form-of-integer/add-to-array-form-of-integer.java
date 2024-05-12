class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> ans = new ArrayList<>();
        int n = num.length;
        int carry =0;
        for(int i =n-1;i>=0;i--){
            int add = k%10 + carry + num[i];
            num[i] = add%10;
            carry = add/10;
            k/=10;
            ans.add(num[i]);
        }
        while(k>0){
            int add = k%10 + carry;
            ans.add(add%10);
            carry = add/10;
            k/=10;
        }
        if(carry!=0) ans.add(carry);
        Collections.reverse(ans);
        return ans;
    }
}