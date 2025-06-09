class Solution {
    public int addDigits(int num) {
        while(num>=10){
            num = added(num);
        }
        return num;
    }
    public int added(int num){
        int sum = 0;
        while(num>0){
            sum += num%10;
            num/=10;
        }
        return sum;
    }
}