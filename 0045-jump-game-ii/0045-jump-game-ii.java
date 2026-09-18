class Solution {
    public int jump(int[] arr) {
        int l = 0, r = 0, jumps = 0;
        while(r < arr.length - 1) {
            int farthest = 0;
            for(int i = l; i<=r; i++) {
                farthest = Math.max(farthest, i + arr[i]);
            }
            jumps++;
            l = r + 1;
            r = farthest;
        }

        return jumps;
    }
}