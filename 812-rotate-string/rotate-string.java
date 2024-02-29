class Solution {
    public boolean rotateString(String s, String goal) {
        int l1 = s.length();
        int l2 = goal.length();
        if(l1!=l2) return false;
        if(s.equalsIgnoreCase(goal)) return true;
        char[] ch1 = s.toCharArray();
        char[] ch2 = goal.toCharArray();
        int i=1;
        while(i<l1){
            if(ch1[0]==ch2[i]){
                if(stringMatch(ch1,ch2,i,l1)) return true;
            }
            i++;
        }
        return false;
    }

    public boolean stringMatch(char[] ch1,char[] ch2,int k,int n){

        for(int i=0;i<n;i++){
            if(ch1[i]!=ch2[(i+k)%n]) return false;
        }
        return true;
    }
}