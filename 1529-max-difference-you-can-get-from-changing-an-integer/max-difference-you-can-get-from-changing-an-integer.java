class Solution {
    public int maxDiff(int num) {
        
        char[] nums = Integer.toString(num).toCharArray();

        char[] a = nums.clone();
        char[] b = nums.clone();
        char x = '*';
        char y = '*';
        char max = '9', min = '1';

        // maximum character
        if (nums[0] != '9')
            x = nums[0];
        else {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != '9') {
                    x = nums[i];
                    break;
                }
            }
        }

        // minimum character
        if (nums[0] != '1') {
            min = '1';
            y = nums[0];
        } else {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != '1' && nums[i] != '0') {
                    min = '0';
                    y = nums[i];
                    break;
                }
            }
        }

        // Replacement
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x)
                a[i] = max;
            if (nums[i] == y)
                b[i] = min;
        }
        return Integer.parseInt(String.valueOf(a)) -
                Integer.parseInt(String.valueOf(b));
    }
}