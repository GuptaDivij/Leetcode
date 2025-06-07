class Solution {
    public String clearStars(String s) {
        int [] leftCharFreq = new int[26];
        char minChar = 'z';
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c!='*'){
                sb.append(c);
                leftCharFreq[c-'a']++;
                if(c<=minChar){
                    minChar=c;
                }
                continue;
            }
            sb.deleteCharAt(sb.lastIndexOf(""+minChar));
            leftCharFreq[minChar-'a']--;
            while(minChar!='z' && leftCharFreq[minChar-'a']==0){
                minChar++;
            }
        }
        return sb.toString();
    }
}

// if several smallest chars, best to delete the closest (on its left)
// traverse left to right - keep track of charFreq and smallest char on the left 
// remove the smallest char on the left - now best way is to use a string builder - sb.lastIndexOf(char) - remove this