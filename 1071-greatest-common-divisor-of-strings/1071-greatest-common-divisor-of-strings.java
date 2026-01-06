class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Step 2: Find gcd of lengths
        int gcdLen = gcd(str1.length(), str2.length());

        // Step 3: Return prefix of gcd length
        return str1.substring(0, gcdLen);
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}