class Solution {
    private Trie trie;
    private HashSet<Integer> lengths;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        trie = new Trie();
        lengths = new HashSet<>();
        for(String word : words) {
            trie.addWord(word);
            lengths.add(word.length());
        }
        // now trie has every word, I just need to check words if they are made up of other words or not
        for(String word : words){
            if(concatenatedWord(word)) res.add(word);
        }
        return res;
    }

    private boolean concatenatedWord(String word){
        boolean[] contained = new boolean[word.length()+1];
        contained[0] = true;
        for(int i = 0; i<word.length(); i++){
            if(!contained[i]) continue;
            for(int len : lengths){
                if(i + len > word.length()) continue;
                String check = word.substring(i, i+len);
                if(check.equals(word)) continue;
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
        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    public Trie(){
        root = new TrieNode();
    }
    public void addWord(String word){
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++){
            int c = word.charAt(i) - 'a';
            if(curr.children[c] == null) curr.children[c] = new TrieNode();
            curr = curr.children[c];
        }
        curr.isEnd = true;
    }
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