class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int hx = a+b;int hy = a-b;int bx = c+d;
        int by = c-d;int qx = e+f;int qy = e-f;
        //rook,queen,bishop are in same position
        if((a==e && b==f)||(c==e && d==f)) return 0;
        //rook,queen are in same x coordinate and bishop is not in that x
        //rook,queen are in same y coordinate and bishop is not in that y
        if((a==e&&a!=c)||(b==f&&b!=d)) return 1;
        //bishop,queen are in same reverse diagonal and rook is not in that reverse diagonal
        //bishop,queen are in same diagonal and rook is not in that diagonal
        if((bx==qx && bx!=hx)||(by==qy && by!=hy)) return 1;
        //rook,queen are in same x coordinate and bishop is in that x
        if(a==e && a==c){
            //bishop is not in between rook and queen
            if(!((b<f && d>b && d<f)||(b>f && d<b && d>f))) return 1;
            //bishop is in between rook and queen
            return 2;
        }
        //rook,queen are in same y coordinate and bishop is in that y
        if(b==f && b==d){
            //bishop is not in between rook and queen
            if(!((a<e && c>a && c<e)||(a>e && c<a && c>e))) return 1;
            //bishop is in between rook and queen
            return 2;
        }
        //bishop,queen are in same reverse diagonal and rook is in that reverse diagonal
        if(bx==qx && bx==hx){
            //rook is not in between bishop and queen
            if((by<qy && hy>by && hy<qy)||(by>qy && hy<by && hy>qy)) return 2;
            //rook is in between bishop and queen
            return 1;
        }
        //bishop,queen are in same diagonal and rook is in that diagonal
        if(by==qy && by==hy){
            //rook is not in between bishop and queen
            if((bx<qx && hx>bx && hx<qx)||(bx>qx && hx<bx && hx>qx)) return 2;
            //rook is in between bishop and queen
            return 1;
        }
        //In any other case simple rook can reach queen in two steps
        return 2;
        /*int rookMoves  = 2;
        boolean isWhiteBishop = (c%2==d%2);
        boolean isWhiteQueen = (e%2==f%2);
        int bishopMoves = (isWhiteBishop!=isWhiteQueen)?Integer.MAX_VALUE;findBishopMoves(c,d,e,f);
        int ans = Math.min(rookMoves,bishopMoves*/

    }
}