class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids){
            // only if it goes left
            int put = asteroid;
            if(asteroid < 0){
                boolean broken = false;
                while(!broken && !stack.isEmpty() && stack.peek() > 0){
                    if(stack.peek() + asteroid == 0) {
                        stack.pop();
                        broken = true;
                    }
                    else if (stack.peek() + asteroid > 0){
                        broken = true; 
                    }
                    else{
                        stack.pop();
                    }                    
                }
                if(!broken) stack.push(asteroid);
            }
            else {
                stack.push(asteroid);
            }
        }
        int [] res = new int[stack.size()];
        for(int i = res.length - 1; i>=0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}