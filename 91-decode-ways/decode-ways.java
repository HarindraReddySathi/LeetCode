class Solution {
    public int numDecodings(String s) {

        int len = s.length();
        char[] ch = s.toCharArray();
        if(ch[0]=='0')return 0;
        Set<String> set = new HashSet<>();
        set.add("1");set.add("2");set.add("3");set.add("4");set.add("5");set.add("6");
        set.add("7");set.add("8");set.add("9");set.add("10");set.add("11");set.add("12");
        set.add("13");set.add("14");set.add("15");set.add("16");set.add("17");set.add("18");
        set.add("19");set.add("20");set.add("21");set.add("22");set.add("23");set.add("24");
        set.add("25");set.add("26");
        int[] ans = new int[len];
        for(int i=len-1;i>=0;i--){
            StringBuilder sb = new StringBuilder();
            sb.append(ch[i]);
            if(i==len-1){
                if(set.contains(sb.toString())){
                    ans[i]=1;
                }
            }else if (i==len-2){
                if(set.contains(sb.toString())){
                    ans[i]+=ans[i+1];
                }
                sb.append(ch[i+1]);
                if(set.contains(sb.toString())){
                    ans[i]+=1;
                }
            }else{
                if(set.contains(sb.toString())){
                    ans[i]+=ans[i+1];
                }
                sb.append(ch[i+1]);
                if(set.contains(sb.toString())){
                    ans[i]+=ans[i+2];
                }
            }
        }
        return ans[0];
    }
}