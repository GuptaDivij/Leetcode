class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        long reversed = reverse(x);
        return x==reversed;
    }
    public long reverse(int x){
        long reversed = 0;
        while(x!=0){
            reversed*=10;
            reversed+=x%10;
            x/=10;
        }
        return reversed;
    }

}