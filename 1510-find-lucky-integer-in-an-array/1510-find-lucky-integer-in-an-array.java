class Solution {
    public int findLucky(int[] arr) {
        int[] temp = new int[arr.length+1];
        for(int n : arr){
            if(n<temp.length) temp[n]++;
        }
        int ans = -1;
        for(int i = 1; i<temp.length; i++) {
            if(temp[i]==i) ans = Math.max(ans, i); 
        }
        return ans;
    }
}