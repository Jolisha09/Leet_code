class Solution {
    private boolean isSquare(int x) {
        int r = (int) Math.sqrt(x);
        return r * r == x;
    }

    public int numSquares(int n) {
        // Case 1
        if (isSquare(n)) return 1;

        // Case 2: remove factors of 4
        while (n % 4 == 0) {
            n /= 4;
        }

        // If reduced n is 7 mod 8 => answer is 4
        if (n % 8 == 7) {
            return 4;
        }

        // Case 3: check sum of two squares
        for (int i = 1; i * i <= n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }

        // Case 4
        return 3;
    }
}