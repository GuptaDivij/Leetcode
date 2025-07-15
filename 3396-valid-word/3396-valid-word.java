class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;

        Set<Character> vowels = new HashSet<>(
            Set.of('a','e','i','o','u', 'A','E','I','O','U'));
        Set<Character> consonants = new HashSet<>(
            Set.of('b','c','d','f','g','h','j','k','l','m',
                   'n','p','q','r','s','t','v','w','x','y','z',
                   'B','C','D','F','G','H','J','K','L','M',
                   'N','P','Q','R','S','T','V','W','X','Y','Z'));
        Set<Character> digits = new HashSet<>(
            Set.of('0','1','2','3','4','5','6','7','8','9'));

        boolean vowel = false;
        boolean consonant = false;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (vowels.contains(c)) vowel = true;
            if (consonants.contains(c)) consonant = true;
            if (!vowels.contains(c) && !consonants.contains(c) && !digits.contains(c)) return false;
        }

        return vowel && consonant;
    }
}
