class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.search(word);
    }

    class Trie{
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode curr = root;
            for(int i = 0; i<word.length(); i++){
                int child = word.charAt(i) - 'a';
                if(curr.children[child]==null) curr.children[child] = new TrieNode();
                curr = curr.children[child];
            }
            curr.isEnd = true;
        }
        public boolean search(String word) {
            return searchSpecial(root, 0, word);
        }
        public boolean searchSpecial(TrieNode curr, int start, String word){
            for(int i = start;i<word.length(); i++){
                if(word.charAt(i)=='.'){
                    for(int idx = 0; idx<26;idx++){
                        if(curr.children[idx]!=null && searchSpecial(curr.children[idx], i+1,word)) return true;
                    }
                    return false;
                }
                int child = word.charAt(i)-'a';
                if(curr.children[child]==null) return false;
                curr = curr.children[child];
            }
            return curr.isEnd;
        }
        class TrieNode{
            boolean isEnd;
            TrieNode[] children;
            public TrieNode(){
                isEnd = false;
                children = new TrieNode[26];
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */