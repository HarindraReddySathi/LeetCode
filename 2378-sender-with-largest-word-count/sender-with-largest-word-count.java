class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        
        Map<String,Integer> map = new TreeMap<>(Collections.reverseOrder());
        int n = messages.length;
        int max = -1;
        for(int i =0;i<n;i++){
            int wordCount = messages[i].split(" ").length;
            map.put(senders[i],map.getOrDefault(senders[i],0)+wordCount);
            if(map.get(senders[i])>max)max = map.get(senders[i]);
        }
        for(String s : map.keySet()){
            if(map.get(s)==max) return s;
        }
        return "";
    }
}