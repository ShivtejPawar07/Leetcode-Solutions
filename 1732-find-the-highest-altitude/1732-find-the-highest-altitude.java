class Solution {
    public int largestAltitude(int[] gain) {
         int maxAltitude = 0; // starting altitude
        int currentAltitude = 0;

        for (int g : gain) {
            currentAltitude += g;      // move to next point
            maxAltitude = Math.max(maxAltitude, currentAltitude); // update highest
        }

        return maxAltitude;
    }
}