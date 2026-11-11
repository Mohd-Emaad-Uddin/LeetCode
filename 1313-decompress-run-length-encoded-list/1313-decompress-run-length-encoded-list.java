class Solution {
    public int[] decompressRLElist(int[] arr) {
        int size = 0;

        for(int i=0; i<arr.length; i+=2) {
            size += arr[i];
        }

        int[] ans = new int[size];
        int k = 0;

        for(int i=0; i<arr.length; i+=2) {
            int freq = arr[i];
            int val = arr[i + 1];
            for(int j=0; j<freq; j++) {
                ans[k++] = val;
            }
        }

        return ans;
    }
}