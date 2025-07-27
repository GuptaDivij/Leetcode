// time complexity - O(valid permutations) - only traverse for the ones where I can place
// space complexity - O(n)

// 1 - n, 2- n-1, 3, n-2 ... n(n-1)(n-2) = n!

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