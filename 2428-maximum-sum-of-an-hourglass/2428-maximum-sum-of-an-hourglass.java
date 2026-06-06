class Solution {
    public int maxSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maxSum = 0;

        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {

                int sum =
                        grid[i][j] + grid[i][j + 1] + grid[i][j + 2]
                        + grid[i + 1][j + 1]
                        + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];

                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}