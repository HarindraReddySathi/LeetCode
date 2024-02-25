class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = Integer.toString(nums[i]);
        }

        // Custom comparator
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab); // Compare concatenated strings
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String str : s) {
            sb.append(str);
        }
        if(sb.charAt(0)=='0') return "0";
        return sb.toString();
    }
    /*
        write a custom comparator for sorting the string array defined above such that 
        when comparing two strings we need to check integer value of s[i]+s[j] is greater than s[j+s[i]]

    */
}