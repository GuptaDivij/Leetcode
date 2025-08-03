class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for(int i = matrix.length-1;i>=0; i--){
            for(int j = matrix[0].length-1;j>=0; j--){
                maxHeap.offer(matrix[i][j]);
                if(maxHeap.size()>k) maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}