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