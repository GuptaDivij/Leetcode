class Trie {

    class TrieNode{
        boolean inEnd;
        TrieNode[] children;

        public TrieNode(){
            inEnd = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0;i<word.length(); i++){
            int child = word.charAt(i)-'a';
            if(curr.children[child]==null){
                curr.children[child]= new TrieNode();
            }
            curr = curr.children[child];
        }
        curr.inEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0;i<word.length(); i++){
            int child = word.charAt(i)-'a';
            if(curr.children[child]==null){
                return false;
            }
            curr = curr.children[child];
        }
        return curr.inEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0;i<prefix.length(); i++){
            int child = prefix.charAt(i)-'a';
            if(curr.children[child]==null){
                return false;
            }
            curr = curr.children[child];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */