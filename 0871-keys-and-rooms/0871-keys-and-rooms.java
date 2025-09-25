// Time complexity = O(n + K)
// Space complexity = O(n)

class Solution {
    private List<List<Integer>> rooms;
    private HashSet<Integer> visited;
    private int n;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.n = rooms.size();
        this.visited = new HashSet<>();
        this.rooms = rooms;
        dfs(0);
        return visited.size()==n;
    }

    public void dfs(int room){
        if(visited.contains(room) || visited.size()==n) return;
        visited.add(room);
        List<Integer> keys = rooms.get(room);
        for(int key: keys) dfs(key);
    }
}