class Solution {
    public int findMin(int[] arr) {
        int low = 0, high = arr.length - 1, min = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[low] < arr[high]) {
                min = Math.min(min, arr[low]);
                break;
            }

            if(arr[low] == arr[mid] && arr[mid] == arr[high]) {
                min = Math.min(min, arr[mid]);
                low++;
                high--;
            }

            else if(arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            }
            else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}