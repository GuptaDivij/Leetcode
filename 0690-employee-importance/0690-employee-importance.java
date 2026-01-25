/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int importance = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee employee: employees) map.put(employee.id, employee);
        Queue<Integer> level = new LinkedList<>();
        level.add(id);
        while(!level.isEmpty()){
            int curr = level.poll();
            importance += map.get(curr).importance;
            List<Integer> list = map.get(curr).subordinates;
            for(int ids : list) level.add(ids);
        }
        return importance;
    }
}
// HashMap -> id, emp
// BFS - for this emp, get all employees, add subs in queue