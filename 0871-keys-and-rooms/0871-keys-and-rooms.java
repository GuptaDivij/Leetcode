// Time complexity = O(n + K)
// Space complexity = O(n)

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        while(!queue.isEmpty()){
            // visit the room
            int room = queue.poll();
            List<Integer> keys = rooms.get(room);
            for(int key : keys){
                if(visited.contains(key)) continue;
                visited.add(key);
                queue.add(key);
            }
            if(visited.size()==n) return true;
        }
        return visited.size()==n;
    }
}