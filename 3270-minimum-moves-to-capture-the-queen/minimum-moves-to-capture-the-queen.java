class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int hx = a+b;int hy = a-b;int bx = c+d;
        int by = c-d;int qx = e+f;int qy = e-f;
        if((a==e && b==f)||(c==e && d==f)) return 0;
        if((a==e&&a!=c)||(b==f&&b!=d)) return 1;
        if((bx==qx && bx!=hx)||(by==qy && by!=hy)) return 1;
        if(a==e && a==c){
            //System.out.println("***");
            if(!((b<f && d>b && d<f)||(b>f && d<b && d>f))) return 1;
            return 2;
        }
        if(b==f && b==d){
            //System.out.println("*");
            if(!((a<e && c>a && c<e)||(a>e && c<a && c>e))) return 1;
            return 2;
        }
        if(bx==qx && bx==hx){
            //System.out.println("###");
            if((by<qy && hy>by && hy<qy)||(by>qy && hy<by && hy>qy)) return 2;
            return 1;
        }
        if(by==qy && by==hy){
            //System.out.println("#");
            if((bx<qx && hx>bx && hx<qx)||(bx>qx && hx<bx && hx>qx)) return 2;
            return 1;
        }
        return 2;
        /*int rookMoves  = 2;
        boolean isWhiteBishop = (c%2==d%2);
        boolean isWhiteQueen = (e%2==f%2);
        int bishopMoves = (isWhiteBishop!=isWhiteQueen)?Integer.MAX_VALUE;findBishopMoves(c,d,e,f);
        int ans = Math.min(rookMoves,bishopMoves*/

    }
}