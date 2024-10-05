class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] target = new int[26];
        for (char c: s1.toCharArray()) {
            target[c - 'a']++;
        }

        int m = s1.length();
        int n = s2.length();
        int[] curr = new int[26];
        for (int i = 0; i < m && i < n; i++) {
            char c = s2.charAt(i);
            curr[c - 'a']++;
        }
        if (isEqual(target, curr)) {
            return true;
        }

        for (int i = 1; i + m - 1 < n; i++) {
            curr[s2.charAt(i - 1) - 'a']--;
            curr[s2.charAt(i + m - 1) - 'a']++;
            if (isEqual(target, curr)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEqual(int[] arr1, int[] arr2) {
        int n = arr1.length;
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}