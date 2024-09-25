class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }

        Map<String, Integer> memo = new HashMap<>();
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int prefixSum = 0;
            for (int len = 1; len <= word.length(); len++) {
                String prefix = word.substring(0, len);
                if (!memo.containsKey(prefix)) {
                    memo.put(prefix, trie.countPrefix(prefix));
                }
                prefixSum += memo.get(prefix);
            }
            ans[i] = prefixSum;
        }
        return ans;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class Trie {
    TrieNode root = new TrieNode();
    int count = 0;

    void insert(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.endOfWord = true;
    }

    int countPrefix(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                break;
            }
        }

        this.count = 0;
        countWord(node);
        return this.count;
    }

    void countWord(TrieNode node) {
        if (node.endOfWord) {
            this.count++;
        }
        if (node.children.size() == 0) {
            return;
        }

        for (char key: node.children.keySet()) {
            countWord(node.children.get(key));
        }
    }
}