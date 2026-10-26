class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String s: sentences) {
            int cnt = s.split(" ").length;
            max = Math.max(max, cnt);
        }

        return max;
    }
}