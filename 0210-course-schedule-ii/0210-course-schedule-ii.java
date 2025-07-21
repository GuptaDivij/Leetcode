class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] courseDependencies = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();
        for(int [] courses : prerequisites){
            int course = courses[0];
            int prereq = courses[1];
            if(!adjacencyList.containsKey(prereq)) adjacencyList.put(prereq, new ArrayList<>());
            adjacencyList.get(prereq).add(course); 
            courseDependencies[course]++;
        }
        Queue<Integer> canDoCourses = new LinkedList<>();
        int [] res = new int[numCourses];
        int completedCourses = 0;
        for(int i = 0; i<numCourses; i++){
            if(courseDependencies[i]==0) {
                res[completedCourses]=i;
                canDoCourses.add(i);
                completedCourses++;
            }
        }
        while(!canDoCourses.isEmpty()){
            int courseId = canDoCourses.poll();
            ArrayList<Integer> futureCourses = adjacencyList.get(courseId);
            if(futureCourses==null) continue;
            for(int course : futureCourses){
                courseDependencies[course]--;
                if(courseDependencies[course]==0){
                    res[completedCourses]=course;
                    canDoCourses.add(course);
                    completedCourses++;
                } 
            }
        }
        return completedCourses==numCourses?res:new int[]{};
    }
}