class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) map.put(emp.id, emp);
        int totalImportance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            int currentId = queue.poll();
            Employee emp = map.get(currentId);
            totalImportance += emp.importance;
            for (int subId : emp.subordinates) queue.offer(subId);
        }
        return totalImportance;
    }
}
