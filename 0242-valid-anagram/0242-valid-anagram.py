class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        sfreq = [0] * 26
        tfreq = [0] * 26

        for i in range(len(s)):
            sfreq[ord(s[i]) - ord('a')] += 1
            tfreq[ord(t[i]) - ord('a')] += 1

        return sfreq == tfreq
