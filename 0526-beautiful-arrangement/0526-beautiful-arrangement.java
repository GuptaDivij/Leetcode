// Time Complexity : O(valid permutations) - only traverse for the ones where I can place
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Approach : I traverse every element and see it can be placed at an index, if so, I mark it as placed, and keep going until all can placed - if it can, I increase the count, then finally, I backtrack

class Solution {
    private int [] hasPlaced; 
    private int count;
    public int countArrangement(int n) {
        hasPlaced = new int[n]; // all are 0 automatically
        count = 0;
        helper(1,n);
        return count;
    }

    public void helper(int num, int n){
        // base case 
        if(num>n) {
            count++;
            return;
        }
        for(int i = 0; i<n; i++){
            if(hasPlaced[i]==0 && (num%(i+1)==0 || (i+1)%num==0)){
                // action
                hasPlaced[i] = 1;
                // recursion
                helper(num+1, n);
                // backtrack
                hasPlaced[i] = 0;
            }
        }
    }
}