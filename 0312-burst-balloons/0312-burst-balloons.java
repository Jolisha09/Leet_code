// Add 1 at both ends so that every balloon always has a left and right boundary.

// Instead of thinking about which balloon to burst FIRST,
// think about which balloon is burst LAST inside the interval [l, r].

// If i is the LAST balloon burst between l and r,
// then every balloon between l and i is already gone,
// and every balloon between i and r is already gone.

// Therefore, when i is finally burst,
// its only remaining neighbors are l and r.

// So the coins gained by bursting i last are:
// arr[l] * arr[i] * arr[r]

// The balloons on the left and right are independent subproblems:
// dfs(l, i) -> maximum coins from balloons between l and i
// dfs(i, r) -> maximum coins from balloons between i and r

// Therefore:
// total = left subproblem
//       + coins from bursting i last
//       + right subproblem

// Try every possible i as the last balloon,
// and take the maximum.

// dp[l][r] stores the maximum coins obtainable
// by bursting all balloons strictly between l and r.

// We use memoization because the same interval [l, r]
// can be reached through many different choices of i.

// Base case:
// If there is no balloon between l and r,
// there is nothing to burst, so the result is 0.

// The boundary balloons l and r are NOT burst by dfs(l, r).
// They are kept alive specifically so they can act as
// the left and right neighbors when the last balloon is burst.

// There is no need for special cases like l == 0 && r == 0.
// The condition l + 1 == r already represents an empty interval.
class Solution {
    Integer dp[][];
    public int maxCoins(int[] nums) {
        int n = nums.length;

        dp = new Integer[n+2][n+2];

        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i=0;i<n;i++)
            arr[i+1] = nums[i];
        
        return dfs(arr,n,0,n+1);
    }

    private int dfs(int arr[],int n,int l,int r){        
        if(l == 0 && r == 0)
            return 1;
        
        if(l == n+1 && r == n+1)
            return 1;
        
        if(dp[l][r] != null)
            return dp[l][r];

        dp[l][r] = 0;
        for(int i=l+1;i<r;i++){
            int sum = dfs(arr,n,l,i) + (arr[l] * arr[i] * arr[r]) + dfs(arr,n,i,r);

            dp[l][r] = Math.max(dp[l][r],sum);
        }

        return dp[l][r];
    }

}