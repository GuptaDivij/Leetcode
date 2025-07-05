class Solution {
    public int[] diStringMatch(String S) {
        int [] ans = new int[S.length() + 1];
        int low = 0;
        int high = S.length();
        for (int i = 0; i<S.length(); i++){
            if(S.charAt(i) == 'I'){
                ans[i] = low;
                low++;
            }
            else{
                ans[i] = high;
                high--;
            }
        }
        ans[S.length()] = low;
        return ans;
    }
}
