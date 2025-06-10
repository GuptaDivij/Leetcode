class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] ans = new int [temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i<temperatures.length; i++){
            while(!stack.isEmpty() && stack.peek()[0]<temperatures[i]){
                ans[stack.peek()[1]] = i-stack.peek()[1];
                stack.pop();
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return ans;
    }
}