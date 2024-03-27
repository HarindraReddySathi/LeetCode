class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> time = new ArrayList<>();
        int n = timePoints.size();
        for (String s : timePoints)
            time.add(minConverter(s));
        Collections.sort(time);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < time.size(); i++)
            ans = Math.min(ans, (time.get(i) - time.get(i - 1)));
        ans = Math.min(ans,time.get(0)+1440-time.get(n-1));
        return ans;
    }

    public int minConverter(String s){
        int ans =0;
        String[] str = s.split(":");
        ans+=(Integer.parseInt(str[0])*60);
        ans+=(Integer.parseInt(str[1]));
        return ans;
    }
}