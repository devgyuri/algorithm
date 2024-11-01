class Solution {
    public String makeFancyString(String s) {
        if (s.length() <= 2) {
            return s;
        }

        int n = s.length();
        List<Character> list = new ArrayList<>();
        list.add(s.charAt(0));
        list.add(s.charAt(1));
        for (int i = 2; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1) || s.charAt(i - 1) != s.charAt(i - 2)) {
                list.add(s.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : list) {
            ans.append(c);
        }
        return ans.toString();
    }
}