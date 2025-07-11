import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int[] roomMeetingCount = new int[n];
        PriorityQueue<Integer> available = new PriorityQueue<>();

        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        for (int i = 0; i < n; i++) {
            available.add(i);
        }

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            int duration = end - start;

            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.add((int) busy.poll()[1]);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                busy.add(new long[]{end, room});
                roomMeetingCount[room]++;
            } else {
                long[] next = busy.poll();
                long newStart = next[0];
                long newEnd = newStart + duration;
                busy.add(new long[]{newEnd, next[1]});
                roomMeetingCount[(int) next[1]]++;
            }
        }
        int max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (roomMeetingCount[i] > max) {
                max = roomMeetingCount[i];
                res = i;
            }
        }
        return res;
    }
}
