class Solution {
    public int reverse(int x) {
        long res = 0;
        int pos = x<0?-1:1;
        while(x!=0){
            res*=10;
            res+=x%10;
            x/=10;
        }
        if(res>Math.pow(2,31)-1 || res<Math.pow(2,31)*-1) return 0;
        return (int)res;
    }
}