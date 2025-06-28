import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getVal(), b.getVal()));

        for (int i = 0; i < nums.length; i++) {
            pq.add(new Element(nums[i], i));
            if (pq.size() > k) pq.poll();
        }

        boolean[] selected = new boolean[nums.length];
        for (Element e : pq) {
            selected[e.getIdx()] = true;
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = 0; i < nums.length && idx < k; i++) {
            if (selected[i]) {
                res[idx++] = nums[i];
            }
        }

        return res;
    }
}

class Element {
    private int val;
    private int idx;

    public Element(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }

    public int getVal() { return val; }
    public int getIdx() { return idx; }
}
