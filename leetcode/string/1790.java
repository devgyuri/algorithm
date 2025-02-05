class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        int leftIdx = -1;
        for (int i = 0; i < n; i++) {
            if (leftIdx == -1 && s1.charAt(i) != s2.charAt(i)) {
                leftIdx = i;
            } else if (s1.charAt(i) != s2.charAt(i)) {
                s2 = swap(s2, leftIdx, i);
                break;
            }
        }
        return s1.equals(s2);
    }

    private String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, s.charAt(i));
        return sb.toString();
    }
}