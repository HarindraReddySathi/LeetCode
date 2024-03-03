class Solution {
    public String fractionToDecimal(int n, int d) {
        if(d==0) return "";
        if(n==0) return "0";
        Map<Long,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        if((n <0 ^ d<0) ){
            sb.append("-");
        }
        long numerator = Math.abs(Long.valueOf(n));
        long denominator = Math.abs(Long.valueOf(d));
        sb.append(numerator/denominator);
        numerator=(numerator%denominator);
        if(numerator==0)return sb.toString();
        sb.append(".");
        map.put(numerator,sb.length());
        while(numerator!=0){
            numerator=numerator*10;
            sb.append(numerator/denominator);
            numerator=numerator%denominator;
            if(map.containsKey(numerator)){
                int p = map.get(numerator);
                sb.insert(p, "(");
                sb.append(")");
                break;
            }
            map.put(numerator,sb.length());
        }
        return sb.toString();
    }
}