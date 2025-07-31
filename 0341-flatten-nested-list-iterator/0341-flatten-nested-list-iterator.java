// Time Complexity : O(1) for next, O(n) for initialization, O(1) amortized for hasNex
// Space Complexity : O(n) for storing in stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Appraoch : I used a stack with native iterator - I added the first list, I know that has next will always be called before next. So for hasnext, I check while stack has something, if the top is empty, I remove it, if the top is an integer, I set nextEl to that and return true, if the top is a list, I add that list to the stack and repeat - now this will be the top. 

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<Iterator<NestedInteger>> stack;
    private NestedInteger nextEl;

    public NestedIterator(List<NestedInteger> nestedList) {
        nextEl = null;
        stack = new Stack<>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return nextEl.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if(!stack.peek().hasNext()) stack.pop();
            else if ((nextEl = stack.peek().next()).isInteger()) return true;
            else  stack.push(nextEl.getList().iterator());
        }
        return false;
    }
}
