class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfPermutations(int n, int[][] requirements) {
        int[] req = new int[n];
        Arrays.fill(req, -1);

        for (int[] r : requirements) {
            req[r[0]] = r[1];
        }

        int[] prev = new int[401];
        prev[0] = 1;

        for (int len = 1; len <= n; len++) {
            int[] curr = new int[401];

            for (int inv = 0; inv <= 400; inv++) {

                // This inversion count is not allowed for this prefix.
                if (req[len - 1] != -1 && req[len - 1] != inv)
                    continue;

                long ways = 0;
                for (int add = 0; add < len && add <= inv; add++) {
                    ways = (ways + prev[inv - add]) % MOD;
                }

                curr[inv] = (int) ways;
            }

            prev = curr;
        }

        long ans = 0;
        for (int inv = 0; inv <= 400; inv++) {
            ans = (ans + prev[inv]) % MOD;
        }

        return (int) ans;
    }
}