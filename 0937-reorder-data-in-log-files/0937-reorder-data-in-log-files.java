// O(n * logLen)

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String[]> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();   
        // O(n * logLen)
        for(String log : logs){
            if (Character.isDigit(log.split(" ")[1].charAt(0))){
                digitLogs.add(log);
            }
            else{
                String[] stringLog = new String[2];
                int idx = log.indexOf(" ");
                // O(logLen)
                stringLog[0] = log.substring(0, idx);
                stringLog[1] = log.substring(idx);
                letterLogs.add(stringLog);
            }
        }
        int i = 0;

        PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> {
            int cmp = a[1].compareTo(b[1]);
            if (cmp != 0) return cmp;
            return a[0].compareTo(b[0]);
        });
        
        // O(numLetterLogs log(numLetterLogs))
        for(String [] log : letterLogs) pq.offer(log);
        // O(numLetterLogs log(numLetterLogs))
        while(!pq.isEmpty()){
            String[] log = pq.poll();
            String res = log[0] + log[1];
            logs[i++] = res;
        }

        for(String log : digitLogs) logs[i++] = log;
        return logs;
    }
}