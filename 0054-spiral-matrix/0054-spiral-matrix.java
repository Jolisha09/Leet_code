class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        // If matrix is empty
        if (matrix.length == 0) {
            return res;
        }

        // Four boundaries
        int srow = 0;
        int scol = 0;

        int erow = matrix.length - 1;
        int ecol = matrix[0].length - 1;

        while (srow <= erow && scol <= ecol) {

            // 1. Go RIGHT
            for (int j = scol; j <= ecol; j++) {
                res.add(matrix[srow][j]);
            }

            // 2. Go DOWN
            for (int i = srow + 1; i <= erow; i++) {
                res.add(matrix[i][ecol]);
            }

            // 3. Go LEFT
            for (int j = ecol - 1; j >= scol; j--) {

                // Prevent duplicate elements
                // when only one row remains
                if (srow == erow) {
                    break;
                }

                res.add(matrix[erow][j]);
            }

            // 4. Go UP
            for (int i = erow - 1; i >= srow + 1; i--) {

                // Prevent duplicate elements
                // when only one column remains
                if (scol == ecol) {
                    break;
                }

                res.add(matrix[i][scol]);
            }

            // Move boundaries inward
            scol++;
            srow++;
            ecol--;
            erow--;
        }

        return res;
    }
}