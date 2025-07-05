class Solution {
    public int findLucky(int[] arr) {
        int[] temp = new int[arr.length+1];
        for(int n : arr){
            if(n<temp.length) temp[n]++;
        }
        for(int i = temp.length-1; i>=1; i--) {
            if(temp[i]==i) return i;
        }
        return -1;
    }
}