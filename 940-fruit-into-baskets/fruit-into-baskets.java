class Solution {
    public int totalFruit(int[] fruits) {
        
        int n = fruits.length;
        if(n==1 || n==2) return n;
        int ans =0;
        int[] variety = new int[2];
        int[] freq = new int[2];
        Arrays.fill(variety,-1);
        int j=0;
        for(int i =0;i<n;i++){

            while(j<n && (variety[0]==-1 || variety[0]==fruits[j] || variety[1]==-1 || variety[1]==fruits[j])){
                if(variety[0]==-1){
                    variety[0]=fruits[j];
                    freq[0]++;
                }else if(variety[0]==fruits[j]){
                    freq[0]++;
                }else if(variety[1]==-1){
                    variety[1]=fruits[j];
                    freq[1]++;
                }else{
                    freq[1]++;
                }
                j++;
            }
            //System.out.println(i+" -- "+j+" -- "+(j-i)+" ** "+variety[0]+" -- "+freq[0]+" -- "+variety[1]+" -- "+freq[1]);
            if(ans<j-i)ans=j-i;
            if(j==n) break;
            if(variety[0]==fruits[i]){
                freq[0]--;
                if(freq[0]==0){
                    System.out.println("******");
                    freq[0]=freq[1];
                    variety[0]=variety[1];
                    freq[1]=0;
                    variety[1]=-1;
                }
            }else if(variety[1]==fruits[i]){
                System.out.println("#####");
                freq[1]--;
                if(freq[1]==0)variety[1]=-1;
            }

        }
        return ans;
    }
}