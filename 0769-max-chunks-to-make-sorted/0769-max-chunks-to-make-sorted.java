class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int res = 0;
        for(int i = 0; i<arr.length; i++){
            max = Math.max(arr[i], max);
            if(i==max) res++;
        }
        return res;
    }
}
// basically arr[i] should be at i
// if it is not, this needs to be sorted for the whole chunk until it's correct place which is i
// so max end for current chunk is max of curr max and arr[i], if we reach end, we can increase the chunk size that everything before it is sorted, now we need new chunks