class Solution {
    public int minimumDeletions(String s) {
        int[] bBefore = new int[s.length()];
        int[] aAfter = new int[s.length()];
        int b = 0;
        for(int i = 0; i<s.length(); i++){
            bBefore[i] = b;
            if(s.charAt(i)=='b')b++;
        }
        int a = 0;
        for(int i = s.length()-1; i>=0; i--){
            aAfter[i] = a;
            if(s.charAt(i)=='a')a++;
        }
        int res = s.length();
        for (int i = 0; i < s.length(); i++) {
            res = Math.min(res, bBefore[i] + aAfter[i]);
        }
        
        // Edge cases: delete all 'a's or all 'b's
        res = Math.min(res, b);       
        res = Math.min(res, aAfter[0]);
        return res;
    }   
}