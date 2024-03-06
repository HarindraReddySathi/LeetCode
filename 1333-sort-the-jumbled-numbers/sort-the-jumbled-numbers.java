class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<Pair> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new Pair(nums[i],converted(mapping,nums[i]),i));
        }
        Collections.sort(ans);
        for(int i=0;i<n;i++){
            nums[i]=ans.get(i).encrypted;
        }
        return nums;
    }

    public int converted(int[] mapping,int n){
        char[] ch = String.valueOf(n).toCharArray();
        for(int i=0;i<ch.length;i++){
            int k = ch[i]-'0';
            ch[i]=(char)(mapping[k]+'0');
        }
        return Integer.parseInt(String.valueOf(ch));
    }

    class Pair implements Comparable<Pair>{
        int encrypted;
        int actual;
        int position;
        public Pair(int encrypted,int actual,int position){
            this.encrypted=encrypted;
            this.actual=actual;
            this.position = position;
        }
        
        @Override
        public int compareTo(Pair other){
            if (this.actual != other.actual) {
                return this.actual>other.actual?1:-1;
            } else {
                return this.position>other.position?1:-1;
            }
        }
    }
    
    /*public int converted(int[] mapping,int n){
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
    }*/
}