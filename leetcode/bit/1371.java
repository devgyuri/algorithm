class Solution {
    public int findTheLongestSubstring(String s) {
        int left = 0, right = s.length() + 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isValidWindow(s, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - 1;
    }

    private boolean isValidWindow(String s, int size) {
        int[] vowels = new int[5];
        for (int i = 0; i < size; i++) {
            addVowel(s.charAt(i), vowels);
        }

        boolean evenFlag = true;
        for (int v: vowels) {
            if (v % 2 != 0) {
                evenFlag = false;
            }
        }
        if (evenFlag) {
            return true;
        }

        for (int i = 0; i < s.length() - size; i++) {
            subVowel(s.charAt(i), vowels);
            addVowel(s.charAt(i + size), vowels);
            evenFlag = true;
            for (int v: vowels) {
                if (v % 2 != 0) {
                    evenFlag = false;
                }
            }
            if (evenFlag) {
                return true;
            }
        }
        return false;
    }

    private void addVowel(char c, int[] vowels) {
        switch (c) {
            case 'a':
                vowels[0]++; break;
            case 'e':
                vowels[1]++; break;
            case 'i':
                vowels[2]++; break;
            case 'o':
                vowels[3]++; break;
            case 'u':
                vowels[4]++; break;
        }
    }

    private void subVowel(char c, int[] vowels) {
        switch (c) {
            case 'a':
                vowels[0]--; break;
            case 'e':
                vowels[1]--; break;
            case 'i':
                vowels[2]--; break;
            case 'o':
                vowels[3]--; break;
            case 'u':
                vowels[4]--; break;
        }
    }
}