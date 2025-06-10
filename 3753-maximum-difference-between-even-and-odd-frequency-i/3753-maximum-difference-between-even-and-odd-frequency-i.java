class Solution {
    public int maxDifference(String s) {
        int[] charFreq = new int[26];
        for(char c : s.toCharArray()) charFreq[c-'a']++;
        int maxOdd = 0, minEven = 0;
        for(int i = 0; i<26;i++){
            if(charFreq[i] == 0){
                continue;
            }
            if(charFreq[i]%2==0){
                if(minEven==0 || charFreq[i]<minEven) minEven = charFreq[i];
            }
            else{
                if(charFreq[i]>maxOdd) maxOdd = charFreq[i]; 
            }
        } 
        return maxOdd-minEven;
    }
}