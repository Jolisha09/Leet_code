
class Solution {
  // Method to find the maximum performance of this team
  public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    // Build {efficiency, speed} pairs
    int[][] engineers = new int[n][2];

    for (int i = 0; i < n; i++) {
      engineers[i] = new int[] { efficiency[i], speed[i] };
    }

    // Sort descending by efficiency: engineers[i][0] is the minimum efficiency
    // of any team drawn from indices 0..i that includes engineer i
    Arrays.sort(engineers, (a, b) -> b[0] - a[0]);

    // Min-heap tracks top-k speeds seen so far
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    long totalSpeed = 0;
    long result = 0;

    for (int i = 0; i < n; i++) {
      // Evict the smallest speed when the window is full
      if (minHeap.size() == k) {
        totalSpeed -= minHeap.poll();
      }

      totalSpeed += engineers[i][1];
      minHeap.offer(engineers[i][1]);

      // engineers[i][0] is the minimum efficiency for any team ending here
      result = Math.max(result, totalSpeed * engineers[i][0]);
    }

    // IMPORTANT: apply % before casting to int to avoid overflow
    // (int) result % MOD would cast to int first, causing data loss
    return (int) (result % 1_000_000_007);
  }
}

// Main Class
public class _1383_Maximum_Performance_of_a_Team {
  // Main method to test maxPerformance
  public static void main(String[] args) {
    int n = 6;
    int[] speed = new int[] { 2, 10, 3, 1, 5, 8 };
    int[] efficiency = new int[] { 5, 4, 3, 9, 7, 2 };
    int k = 2;

    int result = new Solution().maxPerformance(n, speed, efficiency, k);

    System.out.println("The maximum performance of this team is : " + result);
  }
}