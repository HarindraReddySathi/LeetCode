class Solution {
    public int countDays(int days, int[][] meetings) {
        
        Arrays.sort(meetings,(a,b) -> a[0]-b[0]);
        int idleDays = 0;
        int start = meetings[0][0];
        int end = meetings[0][1];
        idleDays+=(start-1);
        for(int i=1;i<meetings.length;i++){
            //Nooverlapp
            if(meetings[i][0]>end){
                idleDays+=(meetings[i][0]-end-1);
                start = meetings[i][0];
                end = meetings[i][1];
            }
            //some OverLapp
            if(meetings[i][1]<=end) continue;
            else end = meetings[i][1];
        }
        return idleDays+(days-end);
    }
}