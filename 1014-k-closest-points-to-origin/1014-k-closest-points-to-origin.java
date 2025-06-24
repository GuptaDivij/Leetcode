class Solution {


    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.distance, a.distance));
        for (int[] point : points) {
            pq.offer(new Element(point));
            if (pq.size() > k) pq.poll();
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) result[i] = pq.poll().point;
        return result;
    }
}

class Element {
    int distance;
    int[] point;
    Element(int[] point) {
        this.distance = point[0]*point[0] + point[1]*point[1];
        this.point = point;
    }
}