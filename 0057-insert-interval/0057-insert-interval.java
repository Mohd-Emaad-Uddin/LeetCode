class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]) {
            list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }

        while(i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        list.add(Arrays.asList(newInterval[0], newInterval[1]));

        while(i < n) {
            list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }

        int[][] ans = new int[list.size()][2];
        for(int j=0; j<list.size(); j++) {
            ans[j][0] = list.get(j).get(0);
            ans[j][1] = list.get(j).get(1);
        }

        return ans;
    }
}