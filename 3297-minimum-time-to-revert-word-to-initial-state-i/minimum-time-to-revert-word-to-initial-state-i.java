class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        
        int n = word.length();
        char[] ch = word.toCharArray();
        int p =0;
        for(int i =1;i<n;i++){
            String forward = word.substring(0,i);
            String backward = word.substring(n-i,n);
            if(forward.equalsIgnoreCase(backward) && (n-i)%k==0){
                p=i;
                //System.out.println(i);
            }
        }
        //System.out.println(j+"===="+k+"==="+(1d*(j+1))/k);
        //System.out.println(Math.ceil((1d*(j+1))/k));
        return (int)Math.ceil((1d*(n-p))/k);
    }
}