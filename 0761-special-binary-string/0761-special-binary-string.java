class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;
            
            if (count == 0) {
                // Recursively solve inner part
                String inner = s.substring(start + 1, i);
                list.add("1" + makeLargestSpecial(inner) + "0");
                start = i + 1;
            }
        }
        
        // Sort descending
        Collections.sort(list, Collections.reverseOrder());
        
        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str);
        }
        
        return result.toString();
    }
}