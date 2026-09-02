
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] temp = new int[points.length][2];
        mergeSort(points, temp, 0, points.length - 1);
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }

        return res;
    }

    private void mergeSort(int[][] p, int[][] temp, int l, int r) {
        if (l >= r)
            return;

        int mid = l + (r - l) / 2;

        mergeSort(p, temp, l, mid);
        mergeSort(p, temp, mid + 1, r);

        int i = l, j = mid + 1, x = l;

        while (i <= mid && j <= r) {
            if (dist(p[i]) <= dist(p[j])) {
                temp[x++] = p[i++];
            } else {
                temp[x++] = p[j++];
            }
        }

        while (i <= mid)
            temp[x++] = p[i++];
        while (j <= r)
            temp[x++] = p[j++];

        for (int idx = l; idx <= r; idx++) {
            p[idx] = temp[idx];
        }
    }

    private int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}