class Pair {
    int row, col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    cnt++;
                    bfs(i, j, visited, grid);
                }
            }
        }

        return cnt;
    }

    private void bfs(int ro, int co, boolean[][] visited, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(ro, co));
        visited[ro][co] = true;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;

            for(int i=0; i<4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol] && grid[nRow][nCol] == '1') {
                    visited[nRow][nCol] = true;
                    q.offer(new Pair(nRow, nCol));
                }
            }
        }
    }
}