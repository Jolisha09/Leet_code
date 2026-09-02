class Solution {
    public int countDigitOne(int n) {
        String s =String.valueOf(n);
        int [][][]dp = new int[s.length()][2][s.length()];
        return solve(s,0,1,0,dp);
    }
    private static int solve(String s, int idx, int tight, int count ,int[][][] dp){
        if(idx == s.length()){
            return count;
        }
        int lb=0;
        int ub =(tight ==1)? s.charAt(idx)-'0':9;
        int res=0;
        if(dp[idx][tight][count]!=0){
            return dp[idx][tight][count];
        }
        for(int digit =lb; digit<=ub; digit++){
            int newTight =(tight==1 && digit ==ub)? 1:0;
            if(digit ==1){
                res += solve(s, idx+1, newTight, count+1, dp);
            }else{
                res += solve(s, idx+1, newTight,count, dp);
            }
        }
        dp[idx][tight][count]=res;
        return res;

    }
}