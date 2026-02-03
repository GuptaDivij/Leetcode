class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // bi allows ai
        // bfs - first do courses with 0 reqs
        // maintain an arr with required courses -> 
        // at each step if you do a course, update all others that depend on it
        // we need int reqs[n]; and Map(a,b) a->b b is list of all courses we can do after a
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] reqsLeft = new int [numCourses];
        for(int [] pair : prerequisites){
            int a = pair[0];
            int b = pair[1];
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a); // list of courses that b allows
            reqsLeft[a]++; // a has to complete these many courses before it can start
        }
        Queue<Integer> taking = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(reqsLeft[i]==0) taking.offer(i); // if a course has no prereqs - do it
        }
        while(!taking.isEmpty()){
            int finished = taking.poll(); // finished this course
            numCourses--;
            // list of courses to which this was a prereq
            List<Integer> canDo = map.containsKey(finished)?map.get(finished):null;
            if(canDo==null) continue;
            for(int course : canDo){
                reqsLeft[course]--;
                if(reqsLeft[course] == 0) taking.offer(course);
            }
        }
        return numCourses == 0;
    }
}