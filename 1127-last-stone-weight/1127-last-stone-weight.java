class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) pq.add(stone);
        while(pq.size()>1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if (stone1==stone2) continue;
            pq.add(stone1-stone2);
        }
        return pq.size()==1?pq.poll():0;
    }
}