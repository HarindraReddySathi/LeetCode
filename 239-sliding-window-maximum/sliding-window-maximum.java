class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
    if (n == 0 || k == 0 || k > n) {
        return new int[0];
    }

    int[] ans = new int[n - k + 1];
    Deque<Integer> q = new ArrayDeque<>();

    // Process the first window separately
    for (int i = 0; i < k; i++) {
        while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
            q.pollLast();
        }
        q.offerLast(i);
    }
    ans[0] = nums[q.peekFirst()];

    // Process the rest of the windows
    for (int i = k; i < n; i++) {
        // Remove elements from the deque which are out of the current window
        if(!q.isEmpty() && q.peekFirst() == i - k) {
            q.pollFirst();
        }
        // Remove elements smaller than the current element from the deque
        while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
            q.pollLast();
        }
        q.offerLast(i);
        ans[i - k + 1] = nums[q.peekFirst()];
    }
    return ans;
    }
}