class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if((a==e && b==f) || (c==e && d==f)) return 0;
        if(a==e){
            if(c!=e) return 1;
            if(!((b<d && d<f)||(b>d && d>f))) return 1;
        }
        if(b==f){
            if(d!=f) return 1;
            if(!((a<c && c<e)||(a>c && c>e))) return 1;
        }

        if(c+d==e+f){
            if(a+b!=e+f) return 1;
            if(!((c-d<a-b && a-b<e-f)||(c-d>a-b && a-b>e-f))) return 1;
        }
        if(c-d==e-f){
            if(a-b!=e-f) return 1;
            if(!((c+d<a+b && a+b<e+f)||(c+d>a+b && a+b>e+f))) return 1;
        }
        return 2;
    }
}