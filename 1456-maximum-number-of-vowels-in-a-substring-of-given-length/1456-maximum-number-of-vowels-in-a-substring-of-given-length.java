class Solution {
   public int maxVowels(String s, int k) {
        int count = 0;
        int max = 0;

        // Count vowels in first window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        max = count;

        // Slide the window
        for (int i = k; i < s.length(); i++) {
            // add new character
            if (isVowel(s.charAt(i))) {
                count++;
            }

            // remove old character
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}