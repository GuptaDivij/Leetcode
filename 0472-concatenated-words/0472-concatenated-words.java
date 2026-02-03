class Solution {
    private Trie trie;
    private HashSet<Integer> lengths;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        // O(1)
        trie = new Trie();
        // O(1)
        lengths = new HashSet<>();
        // O(sum(len))
        for(String word : words) {
            trie.addWord(word);
            lengths.add(word.length());
        }
        // now trie has every word, I just need to check words if they are made up of other words or not
        // O(n * len^2 * k)
        for(String word : words){
            // O(len^2 * k)
            if(concatenatedWord(word)) res.add(word);
        }
        return res;
    }

    // O(len^2 * k)
    private boolean concatenatedWord(String word){
        // O(1)
        boolean[] contained = new boolean[word.length()+1];
        contained[0] = true;
        // O(len^2 * k)
        for(int i = 0; i<word.length(); i++){ // O(len)
            if(!contained[i]) continue;
            // O(k * len)
            for(int len : lengths){ 
                if(i + len > word.length()) continue;
                String check = word.substring(i, i+len); // O(len)
                if(check.equals(word)) continue;
                // O(len)
                if(trie.containsWord(check)) contained[i+len] = true;
                if(contained[word.length()]) return true;
            }
        }
        return false;
    }
}

class Trie{
    TrieNode root;
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        // O(1)
        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    // O(1) 
    public Trie(){
        root = new TrieNode();
    }
    // O(len)
    public void addWord(String word){
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++){
            int c = word.charAt(i) - 'a';
            if(curr.children[c] == null) curr.children[c] = new TrieNode();
            curr = curr.children[c];
        }
        curr.isEnd = true;
    }
    // O(len)
    public boolean containsWord(String word){
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++){
            int c = word.charAt(i) - 'a';
            if(curr.children[c]==null) return false;
            curr = curr.children[c];
        }
        return curr.isEnd;
    } 
}

// need to contain word by word -> not letter by letter
// best idea is to build a trie -> for a current word traverse letter by letter and see if there are at least 2 ends 