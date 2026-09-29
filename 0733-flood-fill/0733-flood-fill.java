class Pair {
    int row, col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public void helper(int[][] ans, int sr, int sc, int color, int n, int m) {
        int num = ans[sr][sc];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));

        ans[sr][sc] = color;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;

            for(int i=0; i<4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && ans[nRow][nCol] == num) {
                    ans[nRow][nCol] = color;
                    q.offer(new Pair(nRow, nCol));
                }
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        if(image[sr][sc] == color)
            return image;

        helper(image, sr, sc, color, n, m);
        return image;
    }
}