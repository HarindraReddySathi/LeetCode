class Solution {
    public int maxArea(int h, int w, int[] hc, int[] vc) {
        
        Arrays.sort(hc);
        Arrays.sort(vc);
        long maxH = Integer.MIN_VALUE;
        long maxV = Integer.MIN_VALUE;

        int prev=0;
        for(int i =0;i<hc.length;i++){
            int k = hc[i]-prev;
            if(k>maxH)maxH=k%1000000007;
            prev=hc[i];
        }
        if(maxH<(h-prev))maxH=(h-prev);
        prev=0;
        for(int i =0;i<vc.length;i++){
            int k = vc[i]-prev;
            if(k>maxV)maxV=k%1000000007;
            prev=vc[i];
        }
        if(maxV<(w-prev))maxV=(w-prev);
        return (int)((maxV*maxH)%1000000007);
    }
}