class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            // map stop to bus
            for (int stop : routes[i]) {
                map.computeIfAbsent(stop, k -> new HashSet<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();

        int buses = 0;

        while (!queue.isEmpty()) {
            buses++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currStop = queue.poll();
                for (int bus : map.getOrDefault(currStop, new HashSet<>())) {
                    if (visitedBuses.contains(bus)) continue;
                    visitedBuses.add(bus);
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return buses;
                        if (visitedStops.add(nextStop)) {
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}


// dp - hard - we don't want to calculate the min to target from everyone
// bfs - add all busses that run on a stop to the queue - this is extra stop, as soon as one of the stops that is in target bus route we return num of stops
// keep track of stops visited - don't visit again