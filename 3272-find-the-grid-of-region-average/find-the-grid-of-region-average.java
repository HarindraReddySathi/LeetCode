class Solution {
    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length;
        int n = image[0].length;
        int[][] res = new int[m][n];
        int[][] count = new int[m][n];
        for(int i=0;i<m-2;i++){
            for(int j=0;j<n-2;j++){
                findAvgIntensity(i,j,image,res,count,threshold);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(count[i][j]==0)res[i][j]=image[i][j];
                else res[i][j]/=(count[i][j]);
            }
        }
        return res;
    }

    public void findAvgIntensity(int i,int j,int[][]image,int[][]res,int[][]count,int threshold){
        int sum =0;
        //System.out.println(i+"----"+j);
        for(int p=i;p<i+3;p++){
            for(int q = j;q<j+3;q++){
                sum+=image[p][q];
                if(p!=i+2 && q==j+2){
                    //System.out.println(p+"$---$"+q);
                    int n1 = Math.abs(image[p+1][q]-image[p][q]);
                    //System.out.println(n1);
                    if(n1>threshold) return;
                }else if(p!=i+2){
                    //System.out.println(p+"**"+q);
                    int n1 = Math.abs(image[p+1][q]-image[p][q]);
                    int n2 = Math.abs(image[p][q+1]-image[p][q]);
                    //System.out.println(n1+"$---$"+n2);
                    if(n1>threshold || n2>threshold) return;
                }else if(p==i+2 && q!=j+2){
                    int n2 = Math.abs(image[p][q+1]-image[p][q]);
                    if(n2>threshold) return;
                }
            }
        }
        //System.out.println(i+"----"+j+"--"+sum);
        sum=sum/9;
        for(int p=i;p<i+3;p++){
            for(int q = j;q<j+3;q++){
                res[p][q]+=sum;
                count[p][q]++;
            }
        }
    }
}