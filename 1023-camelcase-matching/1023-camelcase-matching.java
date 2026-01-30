// O(numQueries * avgQueryLen)
// O(1)

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for(String query: queries) res.add(func(query, pattern));
        return res;
    }
    public boolean func(String query, String pattern){
        if(pattern.length()>query.length()) return false;
        int k = 0;
        for(int i = 0; i<query.length(); i++){
            if(k < pattern.length() && query.charAt(i)==pattern.charAt(k)) k++;
            else if(query.charAt(i)-'a'<0) return false; // capital letters
        }
        return k==pattern.length();
    }
}