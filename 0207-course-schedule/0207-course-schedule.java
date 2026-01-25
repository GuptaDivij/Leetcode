class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] arr = new ArrayList[numCourses];
        int[] courseDependencies = new int[numCourses];
        for(int [] courseList: prerequisites){
            int course = courseList[0];
            int preReq = courseList[1];
            if(arr[preReq] == null) arr[preReq] = new ArrayList<Integer>();
            arr[preReq].add(course);
            courseDependencies[course]++;
        }
        int finishedCourses = 0;
        Queue<Integer> currentCourse = new LinkedList<>();
        for(int i = 0; i<numCourses; i++) {
            if(courseDependencies[i] == 0){
                finishedCourses++;
                currentCourse.add(i);
            }
        }
        while(!currentCourse.isEmpty()){
            int course = currentCourse.poll();
            if(arr[course]==null) continue;
            ArrayList<Integer> nextCourses = arr[course];
            for(int next: nextCourses){
                courseDependencies[next]--;
                if(courseDependencies[next] == 0){
                    finishedCourses++;
                    currentCourse.add(next);
                }
            }
        }
        return numCourses == finishedCourses;
    }
}