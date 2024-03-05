class Solution {
    public String smallestNumber(String pattern) {
        
        int n = pattern.length();
        char[] ch = pattern.toCharArray();
        int[] arr = new int[n+1];
        for(int i=0;i<=n;i++)arr[i]=i+1;
        int i=0;
        int j=0;
        while(i<n && j<n){
            if(ch[i]=='I'){
                i++;j++;
                continue;
            }
            while(j<n && ch[j]=='D'){
                j++;
            }
            //reverse string from i before j
            reverse(arr,i,j);
            i=j;
        }
        StringBuilder sb = new StringBuilder();
        for(i=0;i<=n;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public void reverse(int[] arr,int i,int j){

        int start =i;
        int end =j;
        while(start<=end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}