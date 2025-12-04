class Solution {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;      // just add one and return
                return digits;
            }
            digits[i] = 0;        // set current digit to 0 and continue carry
        }

        // If all digits were 9 (example: 999)
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;

        
    }
}