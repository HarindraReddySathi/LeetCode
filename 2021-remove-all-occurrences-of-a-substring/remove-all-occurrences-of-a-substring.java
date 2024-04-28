class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        int subl = part.length();
        String res = s;

        while(res.indexOf(part) != -1) {
            int idx = res.indexOf(part);

            res = res.substring(0,idx)+res.substring(idx+subl);
        }
        return res;
    }
}