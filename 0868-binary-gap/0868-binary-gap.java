class Solution {
    public int binaryGap(int n) {
      int maxDistance = 0;
        int lastPosition = -1;
        int position = 0;
        
        while (n > 0) {
            if ((n & 1) == 1) {  // If current bit is 1
                if (lastPosition != -1) {
                    maxDistance = Math.max(maxDistance, position - lastPosition);
                }
                lastPosition = position;
            }
            position++;
            n = n >> 1;  // Right shift
        }
        
        return maxDistance;
    }
}