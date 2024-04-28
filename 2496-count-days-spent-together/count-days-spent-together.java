class Solution {
    public int countDaysTogether(String aA, String lA, String aB, String lB) {
        
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(lA.compareTo(aB)<0  || lB.compareTo(aA)<0) return 0;
        String start = (aA.compareTo(aB)>0)?aA:aB;
        String end = (lA.compareTo(lB)>0)?lB:lA;
        int[] s = new int[2];
        int[] e = new int[2];
        s[0] = (start.charAt(0)-'0')*10+(start.charAt(1)-'0');
        e[0] = (end.charAt(0)-'0')*10+(end.charAt(1)-'0');
        s[1] = (start.charAt(3)-'0')*10+(start.charAt(4)-'0');
        e[1] = (end.charAt(3)-'0')*10+(end.charAt(4)-'0');
        if(s[0]==e[0]) return e[1]-s[1]+1;
        int ans = days[s[0]-1]-s[1]+1+e[1];
        for(int i = s[0];i<e[0]-1;i++){
            ans+=days[i];
        }
        return ans;
    }
}