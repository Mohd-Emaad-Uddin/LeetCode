class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> {
            if(a[1] == b[1])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int cnt = 1, freeTime = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= freeTime) {
                cnt++;
                freeTime = intervals[i][1];
            }
        }

        return intervals.length - cnt;
    }
}