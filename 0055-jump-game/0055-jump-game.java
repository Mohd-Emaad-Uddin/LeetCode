class Solution {
    public boolean canJump(int[] arr) {
        int maxIdx = 0;
        for(int i=0; i<arr.length; i++) {
            if(i > maxIdx)
                return false;
            maxIdx = Math.max(maxIdx, i + arr[i]);
        }

        return true;
    }
}