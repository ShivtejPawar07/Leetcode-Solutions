class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        // Business line priority
        Map<String, Integer> order = new HashMap<>();
        order.put("electronics", 1);
        order.put("grocery", 2);
        order.put("pharmacy", 3);
        order.put("restaurant", 4);

        List<String[]> valid = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {

            // 1. Active check
            if (!isActive[i]) continue;

            // 2. Business line check
            if (!order.containsKey(businessLine[i])) continue;

            // 3. Code validation
            if (code[i] == null || code[i].isEmpty()) continue;
            if (!code[i].matches("[a-zA-Z0-9_]+")) continue;

            valid.add(new String[]{businessLine[i], code[i]});
        }

        // Sorting
        Collections.sort(valid, (a, b) -> {
            int cmp = order.get(a[0]) - order.get(b[0]);
            if (cmp != 0) return cmp;
            return a[1].compareTo(b[1]);
        });

        // Result
        List<String> result = new ArrayList<>();
        for (String[] v : valid) {
            result.add(v[1]);
        }

        return result;
    }
}