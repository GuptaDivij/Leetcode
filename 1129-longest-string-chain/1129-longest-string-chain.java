class Solution {
    public int longestStrChain(String[] words) {
        if(words.length==1) return 1;
        int result = 0;
        HashMap<String, Integer> map = new HashMap<>(); // string and max streak
        Arrays.sort(words, (a,b)-> a.length()-b.length()); // I want it to be sorted in terms of length
        for(String word : words){
            // find the substrings
            int max = 1; 
            for(int i = 0; i<word.length(); i++){
                String substring = word.substring(0, i) + word.substring(i+1);
                if(map.containsKey(substring)){
                    max = Math.max(max, map.get(substring) + 1);
                }
            }
            result = Math.max(result, max);
            map.put(word, max);
        }
        return result;
    }
}