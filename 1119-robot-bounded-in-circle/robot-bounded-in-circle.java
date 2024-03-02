class Solution {
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

        /*if(y==0){
            if((x>0 && dir=='E') || (x<0 && dir=='W')) return false;
            return true;
        }
        if(x==0){
            if((y>0 && dir=='N') || (y<0 && dir=='S')) return false;
            return true;
        }
        //Q1
        if(x>0 && y>0){
            if(dir=='N') return false;
            return true;
        }
        //Q4
        if(x>0 && y<0){
            if(dir=='S') return false;
            return true;
        }
        //Q2
        if(x<0 && y>0){
            if(dir=='N') return false;
            return true;
        }
        //Q3
        if(x<0 && y<0){
             if(dir=='S') return false;
            return true;
        }
        return true;*/
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