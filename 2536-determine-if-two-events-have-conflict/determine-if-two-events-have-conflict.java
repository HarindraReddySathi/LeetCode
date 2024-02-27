class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int start1 = minCalculator(event1[0]);
        int end1 = minCalculator(event1[1]);
        int start2 = minCalculator(event2[0]);
        int end2 = minCalculator(event2[1]);
        if((start2>end1)||(start1>end2)) return false;
        return true;
    }

    public int minCalculator(String s){
        String[] arr = s.split(":");
        int ans = 60*Integer.parseInt(arr[0])+Integer.parseInt(arr[1]);
        System.out.println(ans);
        return ans;
    }
}