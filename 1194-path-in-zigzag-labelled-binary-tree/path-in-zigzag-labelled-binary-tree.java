class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        
        List<Integer> zigZagLabelledBT = new ArrayList<>();
        int pow = 0;
        // 1 -> even -1 -> odd
        int isEven = -1;
        while(pow<label){
            pow = (pow+1)*2-1;
            isEven*=-1;
        }

        while(pow >= 1){
            zigZagLabelledBT.add(label);
            int start  = (pow+1)/2;
            int offset = (label-start)/2;
            label = start -1 - offset;
            pow = start -1;
        }

        Collections.reverse(zigZagLabelledBT);
        return zigZagLabelledBT;
    }
}