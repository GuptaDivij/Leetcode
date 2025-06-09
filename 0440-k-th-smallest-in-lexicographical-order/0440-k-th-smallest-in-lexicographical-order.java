class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while(k>0){
            int steps = countStepsBetweenNumbers(n, curr, curr+1);
            if(steps<=k){
                curr++;
                k-=steps;
            }
            else{
                k--;
                curr*=10;
            }
        }
        return curr;
    }

    private int countStepsBetweenNumbers(int n, long num1, long num2){
        int steps = 0;
        while(num1<=n){
            steps+=Math.min(n+1,num2)-num1;
            num1*=10;
            num2*=10;
        }
        return steps;
    }
}