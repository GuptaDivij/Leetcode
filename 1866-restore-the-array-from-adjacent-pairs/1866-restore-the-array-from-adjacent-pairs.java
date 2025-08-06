class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        // Step 2: Find the starting point (element with only one neighbor)
        int start = 0;
        for (int key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                start = key;
                break;
            }
        }

        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        Set<Integer> visited = new HashSet<>();
        result[0] = start;
        visited.add(start);

        for (int i = 1; i < n; i++) {
            for (int neighbor : graph.get(start)) {
                if (!visited.contains(neighbor)) {
                    result[i] = neighbor;
                    visited.add(neighbor);
                    start = neighbor;
                    break;
                }
            }
        }

        return result;
    }
}
