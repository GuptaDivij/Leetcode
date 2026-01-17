class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int pt1 = 0;
        int pt2 = 0;
        while(pt1!=word1.length() && pt2!=word2.length()){
            sb.append(word1.charAt(pt1++));
            sb.append(word2.charAt(pt2++));
        }
        if(pt1!=word1.length()) sb.append(word1.substring(pt1));
        if(pt2!=word2.length()) sb.append(word2.substring(pt2));
        return sb.toString();
    }
}