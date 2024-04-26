class Solution {
    public long findScore(int[] nums) {
        long res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i += 2) { // i 选了 i+1 不能选
            
            // 找到下坡的坡底
            int start = i;
            while (i + 1 < n && nums[i] > nums[i + 1]) i++;

            // 从坡底 i 到坡顶 i0，每隔一个累加
            for (int j = i; j >= start; j -= 2) res += nums[j];
        }
        return res;
    }

    }