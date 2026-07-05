class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int required = need.size(); // number of unique chars we need fully satisfied
        int formed = 0;             // number of unique chars currently satisfied

        int left = 0;
        int[] best = {-1, 0, 0}; // {length, left, right}

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window from the left while it's still valid
            while (left <= right && formed == required) {
                if (best[0] == -1 || right - left + 1 < best[0]) {
                    best[0] = right - left + 1;
                    best[1] = left;
                    best[2] = right;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }

        return best[0] == -1 ? "" : s.substring(best[1], best[2] + 1);
    }
}