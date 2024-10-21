class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> dictionary = new HashSet<>();
        StringBuilder word = new StringBuilder();
        for (char c: s.toCharArray()) {
            word.append(c);
            if (!dictionary.contains(word.toString())) {
                dictionary.add(word.toString());
                word.setLength(0);
            }
        }
        return dictionary.size();
    }
}