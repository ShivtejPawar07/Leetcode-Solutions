import java.util.*;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        String curr = "";
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If digit, build number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // If '[' save number and string
            else if (ch == '[') {
                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = "";
            }

            // If ']' repeat string
            else if (ch == ']') {
                int times = numStack.pop();
                String prev = strStack.pop();

                String temp = "";
                for (int j = 0; j < times; j++) {
                    temp += curr;
                }

                curr = prev + temp;
            }

            // If letter
            else {
                curr += ch;
            }
        }

        return curr;
    }
}
