class Solution {

    private static int max = 1000000007;
    public int monkeyMove(int n) {
         return (int) ((max + pow(n) - 2) % max);
    }
    private static long pow(int n) {
		if (n == 1)
			return 2;
		if (n % 2 == 0) {
			long half = pow(n / 2);
			return (half * half) % max;
		} else {
			long half = pow(n / 2);
			return ((half * half) % max) * 2 % max;
		}
	}

     /*private int mod =1000000007;
    public int monkeyMove(int n) {
        double ways = Math.pow(2,n)%mod;
        return (int)((ways-2)%mod);
    }*/
}