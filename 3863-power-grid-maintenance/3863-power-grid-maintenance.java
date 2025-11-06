import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        HashMap<Integer, Integer> rackIds = new HashMap<>();
        boolean[] offline = new boolean[c + 1];
        ArrayList<Integer>[] graph = new ArrayList[c + 1];
        for (int i = 1; i <= c; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            int p1 = connection[0];
            int p2 = connection[1];
            graph[p1].add(p2);
            graph[p2].add(p1);
        }

        ArrayList<PriorityQueue<Integer>> racks = new ArrayList<>();
        int rackId = 0;
        for (int i = 1; i <= c; i++) {
            if (!rackIds.containsKey(i)) {
                Queue<Integer> queue = new LinkedList<>();
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                queue.add(i);
                rackIds.put(i, rackId);

                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    pq.add(curr);
                    for (int vertex : graph[curr]) {
                        if (!rackIds.containsKey(vertex)) {
                            rackIds.put(vertex, rackId);
                            queue.add(vertex);
                        }
                    }
                }

                racks.add(pq);
                rackId++;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            int op = query[0];
            int vertex = query[1];
            if (op == 2) {
                offline[vertex] = true;
            } else {
                if(!offline[vertex]) {
                    res.add(vertex);
                    continue;
                }
                int rid = rackIds.get(vertex);
                PriorityQueue<Integer> rack = racks.get(rid);
                while (!rack.isEmpty() && offline[rack.peek()]) {
                    rack.poll();
                }
                res.add(rack.isEmpty() ? -1 : rack.peek());
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}
