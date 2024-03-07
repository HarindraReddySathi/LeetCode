
import java.math.BigInteger;

class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {

        if(sx>tx || sy>ty) return false;

        while(sx<=tx && sy<=ty){

            if(tx>ty){
                if(ty>sy) tx%=ty;
                else return (tx-sx)%ty==0;
            }else{
                if(tx>sx) ty%=tx;
                else return (ty-sy)%tx==0;
            }
        }
        return (tx==sx && ty==sy);

         /*while (tx >= sx && ty >= sy) {
            if (tx == ty) break;
            if (tx > ty) {
                if (ty > sy) tx %= ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }
        return (tx == sx && ty == sy);*/
         /*if(tx>=sx && ty>=sy){
            return (gcd(sx,sy)==gcd(tx,ty))? true : false;
         }
         return false;*/
    }

    public int gcd(int a,int b){

        if(a==0) return b;
        if(b==0) return a;
        System.out.println(a+"--"+b);
        if(a>b) return gcd(a%b,b);
        else  return gcd(a,b%a);
    }
}