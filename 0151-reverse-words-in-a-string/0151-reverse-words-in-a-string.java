class Solution {
    public String reverseWords(String s) {
        // 1. Trim leading and trailing spaces
        s = s.trim();
        
        // 2. Split the string by one or more spaces (regex "\\s+")
        String[] words = s.split("\\s+");
        
        // 3. Reverse the words array
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        // 4. Join the words with a single space
        return String.join(" ", words);
    }
}