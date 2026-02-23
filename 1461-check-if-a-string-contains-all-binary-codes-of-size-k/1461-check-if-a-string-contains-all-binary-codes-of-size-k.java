class Solution {
    public boolean hasAllCodes(String s, int k) {
         if (s.length() < k) {
            return false;
        }
        
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            set.add(sub);
        }
        
        return set.size() == (1 << k);
    }
}