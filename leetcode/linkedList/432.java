class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int count = 0;
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insertWord(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.count++;
    }

    void deleteWord(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            int idx = c - 'a';
            node = node.children[idx];
        }
        node.count--;
    }
}

class AllOne {
    Trie trie;

    public AllOne() {
        this.trie = new Trie();
    }
    
    public void inc(String key) {
        trie.insertWord(key);
    }
    
    public void dec(String key) {
        trie.deleteWord(key);
    }
    
    public String getMaxKey() {
        return "";
    }
    
    public String getMinKey() {
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */