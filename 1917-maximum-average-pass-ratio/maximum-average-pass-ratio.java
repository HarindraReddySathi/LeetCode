class Solution {
    public Comparator<Class> comp = new Comparator<>(){
        public int compare(Class c1, Class c2){
            return Double.compare(c1.factor, c2.factor)*(-1);
        }
    };
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Class> pq = new PriorityQueue<>(comp);

        for(int[] i:classes) {
            Class cls = new Class(i[0], i[1]);
            pq.add(cls);
        }

        for(int i=0;i<extraStudents;i++){
           Class c = pq.poll();
           c.update();
           pq.add(c);
        }
        double num = 0d;
        while(!pq.isEmpty()){
            Class c = pq.poll();
            num+=(1d*c.pass)/(1d*c.total);
        }
        num=num/classes.length;
        return Math.round(num * 100000) / 100000.0;
    }
    class Class {
        int pass;
        int total;
        double factor;

        public Class(int pass, int total){
            this.pass = pass;
            this.total = total;
            this.factor = ((1d)*(total-pass))/((1d)*total*(total+1));
        }

        public void update(){
            this.pass++;
            this.total++;
            this.factor = ((1d)*(total-pass))/((1d)*total*(total+1));
        }
    }
}