class Solution {
    public int countSymmetricIntegers(int low, int high) {
        if(high<10) return 0;
        int ans =0;
        int h = Math.min(99,high);
        int l = Math.max(10,low);
        for(int i=l;i<=h;i++){
            if(i/10 == i%10) ans++;
        }
        if(high<1000) return ans;
        h = Math.min(9999,high);
        l = Math.max(1000,low);
        System.out.println(l+"--"+h);
        for(int i=l;i<=h;i++){
            String s = String.valueOf(i);
            int a = Integer.parseInt(s.charAt(0)+"")+ Integer.parseInt(s.charAt(1)+"");
            int b = Integer.parseInt(s.charAt(2)+"")+ Integer.parseInt(s.charAt(3)+"");
            if(a==b){
                ans++;
                System.out.println(i);
            } 
        }
        return ans;
    }
}