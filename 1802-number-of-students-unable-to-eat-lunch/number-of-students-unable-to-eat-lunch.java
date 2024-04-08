class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int c1 = 0;
        int c2 =0;
        for(int i : students){
            if(i==0)c1++;
            else c2++;
        }
        int n = sandwiches.length;
        for(int i : sandwiches){
            if(i==0) c1--;
            else c2--;
            if(c1<0 || c2<0) return n;
            n--;
        }
        return 0;
    }
}