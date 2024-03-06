class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        if(n==1) return asteroids;
        Stack<Integer> s = new Stack<>();
        s.push(asteroids[0]);
        int i=1;
        while(i<n){
            if(s.isEmpty() || asteroids[i]>=0){
                s.push(asteroids[i]);
                i++;
                continue;
            }
            int cur = Math.abs(asteroids[i]);
            int top = s.peek();
            while(!s.isEmpty() && top<cur && top>=0){
                s.pop();
                if(top==cur) break;
                if(!s.isEmpty())top=s.peek();
            }
            if(top<0) s.push(asteroids[i]);
            if(s.isEmpty()) s.push(asteroids[i]);
            if(top==cur) s.pop();
            //if(s.isEmpty()&& top!=cur)s.push(asteroids[i]);
            i++;
        }
        if(s.isEmpty()) return new int[0];
        int[] ans = new int[s.size()];
        for(i=s.size()-1;i>=0;i--){
            ans[i]=s.pop();
        } 
        return ans;
    }
}