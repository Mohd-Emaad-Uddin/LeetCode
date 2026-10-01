class Triplet {
    int row, col, dist;
    public Triplet(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Triplet> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 0) {
                    visited[i][j] = true;
                    q.offer(new Triplet(i, j, 0));
                }
            }
        }

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        int[][] ans = new int[n][m];


        while(!q.isEmpty()) {
            Triplet t = q.poll();
            int row = t.row;
            int col = t.col;
            int dist = t.dist;

            ans[row][col] = dist;
            for(int i=0; i<4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol] && mat[nRow][nCol] == 1) {
                    visited[nRow][nCol] = true;
                    q.offer(new Triplet(nRow, nCol, dist + 1));
                }
            }
        }

        return ans;
    }
}