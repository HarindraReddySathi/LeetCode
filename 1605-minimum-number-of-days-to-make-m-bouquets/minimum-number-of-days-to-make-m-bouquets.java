class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int n = bloomDay.length;
        int[] limit = findLimit(bloomDay);
        int low = limit[0];
        int high = limit[1];
        System.out.println(low + " -- "+ high);
        int minimumDays = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            System.out.println(mid);
            if(isMBouquetsPossible(bloomDay,m,k,mid,n)){
                System.out.println("****");
                minimumDays = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return minimumDays;
    }


    public boolean isMBouquetsPossible(int[] bloomDay,int m,int k,int today,int n){

        int possibleBouquets=0;
        int currentFlowerCount =0;

        for(int i=0;i<n;i++){

            if(bloomDay[i]<=today){
                currentFlowerCount++;
                if(currentFlowerCount>=k){
                    possibleBouquets++;
                    if(possibleBouquets>=m) return true;
                    currentFlowerCount =0;
                } 
            }else{
                currentFlowerCount =0;
            }
        }

        return false;
    }

    public int[] findLimit(int[] arr){
        int[] limit = new int[2];
        limit[0] = 1000000000+1;
        limit[1] = 0;
        for(int i : arr){
            if(i<limit[0]) limit[0]=i;
            if(i>limit[1]) limit[1]=i;
        }
        return limit;
    }
}