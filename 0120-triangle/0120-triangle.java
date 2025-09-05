// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I start from the bottom and make sure each element stores the min sum path to bottom, for the last row its the same as they only need to add their value to reach bottom, for the rows above it, each index j has 2 choices - left or right and these are represented by next row's index j and j + 1. So I update it with sum of that element and min of whatever we can choose from, this way I keep going up and when I am on top, I will have the minimum value I need to go down.

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> currRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i + 1);
            for (int j = 0; j < currRow.size(); j++) {
                currRow.set(j, currRow.get(j) + Math.min(nextRow.get(j), nextRow.get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
