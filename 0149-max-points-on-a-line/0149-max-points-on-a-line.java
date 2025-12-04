class Solution {
    public int maxPoints(int[][] points) {
         if (points.length <= 2) return points.length;
        
        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {

            Map<String, Integer> map = new HashMap<>();
            int samePoint = 1;  // identical points
            int localMax = 0;

            for (int j = i + 1; j < points.length; j++) {

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Reduce slope using GCD
                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;

                // Handle vertical line sign
                if (dx < 0) {
                    dx *= -1;
                    dy *= -1;
                }

                String key = dx + "," + dy;
                map.put(key, map.getOrDefault(key, 0) + 1);

                localMax = Math.max(localMax, map.get(key));
            }

            maxPoints = Math.max(maxPoints, localMax + samePoint);
        }
        return maxPoints;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}