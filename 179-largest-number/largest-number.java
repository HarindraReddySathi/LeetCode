class Solution {
    public String largestNumber(int[] nums) {

        int n = nums.length;
        String[] s = new String[n];
        for(int i =0;i<n;i++)s[i]=String.valueOf(nums[i]);
        int count=0;
        for(int i =0;i<n;i++){
            if(nums[i]==0) count++;
        }
        if(count==n) return "0";
        Comparator<String> comp =new Comparator<>(){
            public int compare(String n1,String n2){
                String s1 = n1+n2;
                String s2 = n2+n1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(s,comp);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(s[i]);
        }
        return sb.toString();
    }
}