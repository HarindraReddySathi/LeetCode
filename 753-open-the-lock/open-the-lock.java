class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for(String s : deadends){
            dead.add(s);
        }
        Set<String> set = new HashSet<>();
        if(dead.contains("0000")) return -1;
        if(target.equals("0000")) return 0;
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        set.add("0000");
        int level =1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                char[] cur = q.poll().toCharArray();
                for(int j=0;j<4;j++){
                    if(cur[j]=='9') cur[j]='0';
                    else cur[j]++;
                    String c = String.valueOf(cur);
                    if(dead.contains(c) || set.contains(c)){
                        if(cur[j]=='0') cur[j]='9';
                        else cur[j]--;
                        continue;
                    }
                    System.out.println(c);
                    if(c.equals(target)) return level;
                    set.add(c);
                    q.add(c);
                    if(cur[j]=='0') cur[j]='9';
                    else cur[j]--;
                }
                for(int j=0;j<4;j++){
                    if(cur[j]=='0') cur[j]='9';
                    else cur[j]--;
                    String c = String.valueOf(cur);
                    if(dead.contains(c) || set.contains(c)){
                        if(cur[j]=='9') cur[j]='0';
                        else cur[j]++;
                        continue;
                    }
                    System.out.println(c);
                    if(c.equals(target)) return level;
                    set.add(c);
                    q.add(c);
                    if(cur[j]=='9') cur[j]='0';
                    else cur[j]++;
                }
            }
            level++;
        }
        return -1;
    }
}