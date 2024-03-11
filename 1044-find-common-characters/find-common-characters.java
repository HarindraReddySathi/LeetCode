class Solution {
    public List<String> commonChars(String[] words) {
        
        int[] main = new int[26];
        
        for(int i=0;i<words.length;i++){
            char[] ch = words[i].toCharArray();
            if(i==0){
                for(char c : ch)
                    main[c-'a']++;
            }else{
                int[] temp = new int[26];
                for(char c : ch)
                    temp[c-'a']++;
                for(int j=0;j<26;j++){
                    if(temp[j]!=0)
                        main[j]=Math.min(temp[j],main[j]);
                    else
                        main[j]=0;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i=0;i<26;i++){
            for(int j=0;j<main[i];j++)ans.add((char)(i+'a')+"");
        }
        return ans;
    }
}