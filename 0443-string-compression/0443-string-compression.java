class Solution {
    public int compress(char[] chars) {
        int write = 0;   // index to write compressed chars
        int read = 0;    // index to read original chars

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count consecutive same characters
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = currentChar;

            // Write the count if greater than 1
            if (count > 1) {
                String cnt = String.valueOf(count);
                for (char c : cnt.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write; 
    }
}