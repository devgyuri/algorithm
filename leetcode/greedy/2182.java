class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        int curr = 25;
        int prev = 25;
        int currLimit = 0;
        while (curr >= 0) {
            while (currLimit < repeatLimit && curr >= 0 && count[curr] == 0) {
                ans.append((char) (curr + 'a'));
                count[curr]--;
                currLimit++;
                prev--;
            }
      
            prev = Math.min(prev, curr - 1);
            while (currLimit == repeatLimit && prev >= 0 && count[prev] == 0) {
                prev--;
            }
            if (prev == -1) {
                break;
            }
      
            if (currLimit == repeatLimit) {
                ans.append((char) (prev + 'a'));
                count[prev]--;
                currLimit = 1;
            } else {
                ans.append((char) (curr + 'a'));
                count[curr]--;
                currLimit++;
            }
        }
        return ans.toString();
    }
}