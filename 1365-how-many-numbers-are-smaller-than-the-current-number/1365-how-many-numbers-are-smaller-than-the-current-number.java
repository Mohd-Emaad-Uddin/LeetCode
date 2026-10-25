class Solution {
    public int[] smallerNumbersThanCurrent(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++) {
            int cnt = 0;
            for(int j=0; j<n; j++) {
                if(i != j && arr[j] < arr[i])
                    cnt++;
            }
            ans[i] = cnt;
        }

        return ans;
    }
}