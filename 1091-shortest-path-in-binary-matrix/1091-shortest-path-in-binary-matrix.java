class Triplet {
    int row, col, dist;

    public Triplet(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {

    private int[] dRow = {-1, -1, -1, 0, 1, 1, 1, 0};
    private int[] dCol = {-1,  0,  1, 1, 1, 0, -1, -1};

    public int shortestPathBinaryMatrix(int[][] mat) {
        int n = mat.length;

        if(mat[0][0] == 1 || mat[n-1][n-1] == 1)
            return -1;

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        Queue<Triplet> q = new LinkedList<>();
        q.offer(new Triplet(0, 0, 0));

        while(!q.isEmpty()) {
            Triplet t = q.poll();
            int row = t.row;
            int col = t.col;
            int dist = t.dist;

            if(row == n-1 && col == n-1)
                return dist + 1;

            for(int i=0; i<8; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && mat[nRow][nCol] == 0 && !visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    q.offer(new Triplet(nRow, nCol, dist + 1));
                }
            }
        }

        return -1;
    }
}