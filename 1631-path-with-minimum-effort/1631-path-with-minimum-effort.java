class Triplet implements Comparable<Triplet>{
    int diff, row, col;
    public Triplet(int diff, int row, int col) {
        this.diff = diff;
        this.row = row;
        this.col = col;
    }

    public int compareTo(Triplet t) {
        return Integer.compare(this.diff, t.diff);
    }
}

class Solution {
    public int minimumEffortPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.offer(new Triplet(0, 0, 0));

        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0] = 0;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while(!pq.isEmpty()) {
            Triplet t = pq.remove();
            int diff = t.diff;
            int row = t.row;
            int col = t.col;

            if(row == n-1 && col == m-1)
                return diff;

            for(int i=0; i<4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    int newDiff = Math.max(Math.abs(mat[row][col] - mat[nRow][nCol]), diff);
                    System.out.print(newDiff + " ");
                    if(newDiff < dist[nRow][nCol]) {
                        dist[nRow][nCol] = newDiff;
                        pq.offer(new Triplet(newDiff, nRow, nCol));
                    }
                }
            }
        }

        return -1;
    }
}