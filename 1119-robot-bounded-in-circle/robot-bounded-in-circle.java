class Solution {


   /* 
   Always check this solution to exactly know how to repersent directions
   class Solution {
    public boolean isRobotBounded(String instructions) {
        int dir[][] = {{0,1}, {-1, 0}, {0, -1}, {1,0}};
        int i = 0;
        int x = 0;
        int y = 0;
       
        for(int s = 0; s < instructions.length(); s++){
            if(instructions.charAt(s) == 'L'){
                i = (i + 1) % 4;
            }
            else if(instructions.charAt(s) == 'R'){
                i = (i + 3) % 4;
            }
            else{
                x = x + dir[i][0];
                y = y + dir[i][1];
            }
        }
        return x == 0 && y == 0 || i != 0;
    }
}*/







    public boolean isRobotBounded(String instructions) {
        
        Map<Character,Map<Character,Character>> map = directionMapCreator();
        Map<Character,Integer[]> m = distanceEstimateCreator();
        int x = 0;
        int y = 0;
        char dir ='N';
        char[] ch = instructions.toCharArray();
        int n = ch.length;

        for(int i=0;i<n;i++){
            if(ch[i]=='G'){
                Integer[] change = m.get(dir);
                x+=change[0];
                y+=change[1];
            }else{
                dir = map.get(dir).get(ch[i]);
            }
        }

        System.out.println(x+"--"+y+"--"+dir);
        if(x==0 && y==0) return true;
        if(dir=='N') return false;
        return true;

    }

    public Map<Character,Integer[]> distanceEstimateCreator(){
         Map<Character,Integer[]> m = new HashMap<>();
        m.put('N',new Integer[] {0,1});
        m.put('S',new Integer[] {0,-1});
        m.put('E',new Integer[] {1,0});
        m.put('W',new Integer[] {-1,0});
        return m;
    }

    public Map<Character,Map<Character,Character>> directionMapCreator(){
        Map<Character,Map<Character,Character>> map = new HashMap<>();
        Map<Character,Character> m = new HashMap<>();
        m.put('L','W');
        m.put('R','E');
        map.put('N',m);
        m = new HashMap<>();
        m.put('L','E');
        m.put('R','W');
        map.put('S',m);
        m = new HashMap<>();
        m.put('L','N');
        m.put('R','S');
        map.put('E',m);
        m = new HashMap<>();
        m.put('L','S');
        m.put('R','N');
        map.put('W',m);
        return map;
    } 
}