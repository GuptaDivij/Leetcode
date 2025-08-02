// Approach : I will get the frequencies of both in the map, if the freq is 0, it is already fine, no need to worry abt it, if the freq is positive, it means basket1 has more of these, if negative it means basket2 has more. For anything with odd freq, it is impossible to balance it out. So for every even balance, I just need to move half, if positive, I need to move it from b1 to b2, if negative, I need to move from b2 to b1. Now, I made a difference object which tells me about the cost and the frequency. What I am not doing is, adding all positve (extra in b1) to a minheap according to price and adding all negative to maxheap according to price - this way, I can map lowest costs with highest costs and get rid of these in a greedy manner. So for remaining, lets say b1 has freq 3 and b2 has -2, this means b1 has 1 extra, after 2 are matched from both sides, b1 should still remain in the heap with freq being 1 (3+-2)

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = basket1.length;

        int globalMin = Integer.MAX_VALUE;

        for (int val : basket1) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            globalMin = Math.min(globalMin, val);
        }

        for (int val : basket2) {
            freq.put(val, freq.getOrDefault(val, 0) - 1);
            globalMin = Math.min(globalMin, val);
        }

        List<Integer> toSwap = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int fruit = entry.getKey();
            int imbalance = entry.getValue();
            if (imbalance % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(imbalance) / 2; i++) {
                toSwap.add(fruit);
            }
        }

        Collections.sort(toSwap);

        long cost = 0;
        int m = toSwap.size();
        for (int i = 0; i < m / 2; i++) {
            cost += Math.min(toSwap.get(i), 2 * globalMin);
        }

        return cost;
    }
}
