class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] nums1 = num1.split("\\+");
        String[] nums2 = num2.split("\\+");
        int a = Integer.parseInt(nums1[0]);
        int c = Integer.parseInt(nums2[0]);
        String[] n1 = nums1[1].split("i");
        String[] n2 = nums2[1].split("i");
        int b = Integer.parseInt(n1[0]);
        int d = Integer.parseInt(n2[0]);
        int real = (a*c-b*d);
        int imag = (a*d+b*c);
        StringBuilder sb = new StringBuilder();
        sb.append(real);
        sb.append("+");
        sb.append(imag);
        sb.append("i");
        return sb.toString();
    }
}