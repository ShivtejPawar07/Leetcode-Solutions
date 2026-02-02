class Solution {
    public int[] asteroidCollision(int[] asteroids) {
         Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                if (Math.abs(stack.peek()) < Math.abs(a)) {
                    stack.pop();          // top explodes
                    continue;
                } else if (Math.abs(stack.peek()) == Math.abs(a)) {
                    stack.pop();          // both explode
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;     // current explodes
                    break;
                }
            }

            if (!destroyed) {
                stack.push(a);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}