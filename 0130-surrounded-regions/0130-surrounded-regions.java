class Solution {
    public void solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if((i == 0 || j == 0 || i == n - 1 || j == m - 1) && mat[i][j] == 'O') {    
                    dfs(i, j, visited, mat, n, m, dRow, dCol);
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 'O' && !visited[i][j]) {
                    mat[i][j] = 'X';
                }       
            }
        }

        
    }

    public void dfs(int ro, int co, boolean[][] visited, char[][] mat, int n, int m, int[] dRow, int[] dCol) {
        visited[ro][co] = true;

        for(int i=0; i<4; i++) {
            int row = ro + dRow[i];
            int col = co + dCol[i];

            if(row >= 0 && row < n && col >= 0 && col < m && !visited[row][col] && mat[row][col] == 'O') {
                dfs(row, col, visited, mat, n, m, dRow, dCol);
            }
        }
    }
}