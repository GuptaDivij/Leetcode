class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            // visit the room
            int room = queue.poll();
            visited.add(room);
            List<Integer> keys = rooms.get(room);
            for(int key : keys){
                if(visited.contains(key)) continue;
                queue.add(key);
            }
        }
        return visited.size()==n;
    }
}