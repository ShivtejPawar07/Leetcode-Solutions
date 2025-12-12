class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        final int l = 2; // length of "id"

        int[] result = new int[numberOfUsers];
        int[] lookup = new int[numberOfUsers]; // initially 0 means online

        // Sort events:
        // 1️⃣ by timestamp
        // 2️⃣ OFFLINE first, MESSAGE next at same timestamp
        Collections.sort(events, (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1 != t2) return t1 - t2;

            // OFFLINE should come before MESSAGE
            int typeA = a.get(0).equals("MESSAGE") ? 1 : 0;
            int typeB = b.get(0).equals("MESSAGE") ? 1 : 0;
            return typeA - typeB;
        });

        for (List<String> e : events) {
            String type = e.get(0);
            int timestamp = Integer.parseInt(e.get(1));

            if (type.equals("OFFLINE")) {
                int user = Integer.parseInt(e.get(2));
                lookup[user] = timestamp + 60;
                continue;
            }

            String msg = e.get(2);

            if (msg.equals("ALL")) {
                for (int i = 0; i < numberOfUsers; i++) {
                    result[i]++;
                }
            }
            else if (msg.equals("HERE")) {
                for (int i = 0; i < numberOfUsers; i++) {
                    if (lookup[i] <= timestamp) {
                        result[i]++;
                    }
                }
            }
            else {
                // Parse message like: "id1 id23 id4"
                String s = msg;
                int j = 0;

                for (int i = 0; i < s.length(); i++) {
                    if (i + 1 == s.length() || s.charAt(i + 1) == ' ') {
                        // Extract substring: start = j + l, length = i - (j + l) + 1
                        int start = j + l;
                        int end = i;

                        if (start <= end) {
                            int user = Integer.parseInt(s.substring(start, end + 1));
                            result[user]++;
                        }

                        j = i + 2; // skip space
                    }
                }
            }
        }

        return result;
    }
}