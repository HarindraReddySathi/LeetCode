class Robot {

    int[] position,limit ;
    int stepsTaken;
    String[] dirName = {"East","North","West","South"};
    int curDirection;
    public Robot(int width, int height) {
        this.position = new int[2];
        this.curDirection=0;
        this.limit = new int[2];
        this.limit[0]=width-1;
        this.limit[1]=height-1;

    }
    
    public void step(int num) {
        stepsTaken+=num;
        int remain = stepsTaken % (2 * (limit[0] + limit[1]));
        if(remain==0){
            position = new int[]{0, 0};
            curDirection=3;
            return;
        }
        if (remain <= limit[0]){
            position = new int[]{remain, 0};
            curDirection=0;
            return;
        }  
        remain -= limit[0];
        if (remain <= limit[1]){
            position = new int[]{limit[0], remain};
            curDirection=1;
            return;
        }
        remain -= limit[1];
        if (remain <= limit[0]){
            position = new int[]{limit[0] - remain, limit[1]};
            curDirection=2;
            return;
        }
        remain -= limit[0];
        position = new int[]{0, limit[1]-remain};
        curDirection=3;
    }
    
    public int[] getPos() {
        return position;
    }
    
    public String getDir() {
        return dirName[curDirection];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */