// Time Complexity : O(lenS + lenP)
// Space Complexity : O(1) - constant space for both
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Approach : I used frequency arrays to store the frequency of each character. Then I use a sliding window on length equal to p's length and add frequency of next character and reduce of first character if size becomes more. If the freq arrays are equal, I add the start index to the result, else I keep searching.

class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    int lenS = s.length(), lenP = p.length();
    if (lenS < lenP) return new ArrayList();
    int [] pCount = new int[26];
    int [] sCount = new int[26];
    for (char ch : p.toCharArray()) pCount[(int)(ch - 'a')]++;
    List<Integer> res = new ArrayList();
    for (int i = 0; i < lenS; ++i) {
      sCount[s.charAt(i)-'a']++;
      if (i >= lenP) sCount[s.charAt(i-lenP)-'a']--;
      if (Arrays.equals(pCount, sCount)) res.add(i-lenP+1);
    }
    return res;
  }
}