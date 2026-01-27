class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        // Flatten the board
        int[] arr = new int[n * n];
        Arrays.fill(arr, -1);

        int idx = 0;
        int dir = 1;
        for (int r = n - 1; r >= 0; r--) {
            if (dir == 1) {
                for (int c = 0; c < n; c++) {
                    if (board[r][c] != -1)
                        arr[idx] = board[r][c] - 1;
                    idx++;
                }
            } else {
                for (int c = n - 1; c >= 0; c--) {
                    if (board[r][c] != -1)
                        arr[idx] = board[r][c] - 1;
                    idx++;
                }
            }
            dir *= -1;
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n];

        q.offer(0);
        visited[0] = true;
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int curr = q.poll();
                if (curr == n * n - 1) return moves;

                for (int d = 1; d <= 6; d++) {
                    int next = Math.min(curr + d, n * n - 1);
                    if (arr[next] != -1)
                        next = arr[next];
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
