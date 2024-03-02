class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<Pair> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new Pair(nums[i],converted(mapping,nums[i]),i));
        }
        Collections.sort(ans,(a, b) -> a.compare(b));
        for(int i=0;i<n;i++){
            nums[i]=ans.get(i).encrypted;
        }
        return nums;
    }

    public int converted(int[] mapping,int n){
        Stack<Integer> s = new Stack<>();
        if(n==0) return mapping[0];
        while(n>0){
            s.push(mapping[n%10]);
            n=n/10;
        }
        int ans = 0;
        while(!s.isEmpty()){
            ans+=ans*10+s.pop();
        }
        return ans;
    }

    class Pair{
        int encrypted;
        int actual;
        int position;
        public Pair(int encrypted,int actual,int position){
            this.encrypted=encrypted;
            this.actual=actual;
            this.position = position;
        }
        public int compare(Pair other){
            if (this.actual != other.actual) {
                return Integer.compare(this.actual, other.actual);
            } else {
                return Integer.compare(this.position, other.position);
            }
        }
    }
}