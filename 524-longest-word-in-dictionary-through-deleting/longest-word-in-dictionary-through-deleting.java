class Solution {
    public String findLongestWord(String str, List<String> dictionary) {
        char[] ch = str.toCharArray();
        int n = ch.length;
        int[] pointer = new int[dictionary.size()];
        int max = -1;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < dictionary.size(); j++) {
                String s = dictionary.get(j);
                if (s.length()>pointer[j] && s.charAt(pointer[j]) == ch[i]){
                    pointer[j]++;
                    if(s.length()==pointer[j]){
                        if(s.length()>max){
                            max=s.length();
                            ans = new ArrayList<>();
                            ans.add(s);
                        }else if(s.length()==max){
                            ans.add(s);
                        }
                    }
                }
            }
        }
        Collections.sort(ans);
        return (ans.size()==0)?"":ans.get(0);
    }
}