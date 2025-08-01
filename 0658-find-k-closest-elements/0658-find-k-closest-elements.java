class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = binarySearch(arr, x);
        int left = right - 1;
        LinkedList<Integer> res = new LinkedList<>();
        
        while (k > 0) {
            int leftDistance = left >= 0 ? Math.abs(arr[left] - x) : Integer.MAX_VALUE;
            int rightDistance = right < arr.length ? Math.abs(arr[right] - x) : Integer.MAX_VALUE;
            if (leftDistance <= rightDistance) {
                res.addFirst(arr[left]);
                left--;
            } else {
                res.addLast(arr[right]);
                right++;
            }
            k--;
        }
        return res;
    }

    public int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] > x) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
