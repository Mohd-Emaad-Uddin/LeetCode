class Triplet {
    int row, col, time;
    public Triplet(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
} 

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Triplet> q = new LinkedList<>();
        int cntFresh = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.offer(new Triplet(i, j, 0));
                }

                if(grid[i][j] == 1)
                    cntFresh++;
            }
        }

        int maxTime = 0, cnt = 0;
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        while(!q.isEmpty()) {
            Triplet t = q.poll();
            int row = t.row;
            int col = t.col;
            int time = t.time;
            maxTime = Math.max(maxTime, time);

            for(int i=0; i<4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                    visited[nRow][nCol] = true;
                    q.offer(new Triplet(nRow, nCol, time + 1));
                    cnt++;
                }
            }
        }

        return (cntFresh == cnt) ? maxTime : -1;
    }
}