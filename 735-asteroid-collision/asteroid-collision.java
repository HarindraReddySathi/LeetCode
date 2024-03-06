class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        if(n==1) return asteroids;
        Stack<Integer> s = new Stack<>();
        for(int asteroid : asteroids){
            boolean consider = true;
            while(!s.isEmpty() && (s.peek()>0 && asteroid<0)){

                if(s.peek()==Math.abs(asteroid)){
                    consider=false;
                    s.pop();
                    break;
                }

                if(Math.abs(asteroid)<s.peek()){
                    consider=false;
                    break;
                }

                s.pop();

            }
            if(consider)s.push(asteroid);
        }

        n = s.size();
        int[] ans = new int[n];
        if(n==0) return ans;
        for(int i=n-1;i>=0;i--)ans[i]=s.pop();
        return ans;
    }
}