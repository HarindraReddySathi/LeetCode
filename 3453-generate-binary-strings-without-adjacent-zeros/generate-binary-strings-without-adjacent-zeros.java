class Solution {
    public List<String> validStrings(int n) {
        
        StringBuilder sb = new StringBuilder();
        List<String> allValidStrings = new ArrayList<>();
        generateValidString(allValidStrings,0,n,'1',sb);
        return allValidStrings;
    }

    public void generateValidString(List<String> allValidStrings, int level, int n,char prev,StringBuilder sb){

        if(level ==n){
            allValidStrings.add(sb.toString());
            return;
        }
        generateValidString(allValidStrings,level+1,n,'1',sb.append("1"));
        sb.deleteCharAt(sb.length()-1);
        if(prev != '0'){
            generateValidString(allValidStrings,level+1,n,'0',sb.append("0"));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}