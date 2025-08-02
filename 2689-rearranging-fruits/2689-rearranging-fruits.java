class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int globalMin = Integer.MAX_VALUE;

        for (int fruit : basket1) {
            freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);
            globalMin = Math.min(globalMin, fruit);
        }

        for (int fruit : basket2) {
            freq.put(fruit, freq.getOrDefault(fruit, 0) - 1);
            globalMin = Math.min(globalMin, fruit);
        }

        PriorityQueue<Difference> b1 = new PriorityQueue<>((a, b) -> a.cost - b.cost); // min-heap
        PriorityQueue<Difference> b2 = new PriorityQueue<>((a, b) -> b.cost - a.cost); // max-heap

        int totalDiff = 0;
        for (int fruit : freq.keySet()) {
            int count = freq.get(fruit);
            if (count == 0) continue;
            if (count % 2 != 0) return -1;

            int half = count / 2;
            totalDiff += half;

            if (half > 0) b1.offer(new Difference(fruit, half)); // extra in basket1
            else b2.offer(new Difference(fruit, half)); // extra in basket2
        }

        if (totalDiff != 0) return -1;

        long cost = 0;
        while (!b1.isEmpty() && !b2.isEmpty()) {
            Difference d1 = b1.poll();
            Difference d2 = b2.poll();

            int moveCount = Math.min(d1.freq, -d2.freq);
            int effectiveCost = Math.min(Math.min(d1.cost, d2.cost), 2 * globalMin);
            cost += (long) moveCount * effectiveCost;

            int remaining = d1.freq + d2.freq;
            if (remaining > 0) b1.offer(new Difference(d1.cost, remaining));
            else if (remaining < 0) b2.offer(new Difference(d2.cost, remaining));
        }

        return cost;
    }

    class Difference {
        int cost;
        int freq;

        public Difference(int cost, int freq) {
            this.cost = cost;
            this.freq = freq;
        }
    }
}
