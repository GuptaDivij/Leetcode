class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;
        Map<Integer, Integer> xToMaxY = new HashMap<>();

        // For each unique x[i], keep the maximum y[i]
        for (int i = 0; i < n; i++) {
            if (!xToMaxY.containsKey(x[i]) || y[i] > xToMaxY.get(x[i])) {
                xToMaxY.put(x[i], y[i]);
            }
        }
        if (xToMaxY.size() < 3) return -1;

        List<Integer> maxYValues = new ArrayList<>(xToMaxY.values());
        Collections.sort(maxYValues, Collections.reverseOrder());

        return maxYValues.get(0) + maxYValues.get(1) + maxYValues.get(2);
    }
}
