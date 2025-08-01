class Solution {
    public double myPow(double x, int n) {
        if(x==1) return 1;
        if(x==-1 && n%2==0) return 1;
        if(n==Integer.MIN_VALUE) return 0;
        if(n==1) return x;
        if(n<0){
            x=1/x;
            n*=-1; 
        }
        double res = 1;
        while(n>0){
            if(n%2==1){
                res*=x;
                n--;
            }
            x*=x;
            n/=2;
        }
        return res;
    }
}