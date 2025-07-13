class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        PriorityQueue<Integer> playersPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> trainersPQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int player : players) playersPQ.add(player);
        for(int trainer : trainers) trainersPQ.add(trainer);
        int ct = 0;
        while(!trainersPQ.isEmpty()){
            if(playersPQ.isEmpty()) return ct;
            int player = playersPQ.poll();
            if(player>trainersPQ.peek()) continue;
            ct++;
            trainersPQ.poll();
        }
        return ct;
    }
}

// nxm -> for every player, find closest one
// 2 max heaps - > match max with max 