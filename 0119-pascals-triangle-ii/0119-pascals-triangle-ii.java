class Solution {
    public List<Integer> generateRow(int row) {
        List<Integer> list = new ArrayList<>();

        long ans = 1;
        list.add(1);

        for(int col = 1; col < row; col++) {
            ans = (ans * (row - col)) / col;
            list.add((int)ans);
        }

        return list;
    }

    public List<Integer> getRow(int rowIndex) {
        return generateRow(rowIndex + 1);
    }
}