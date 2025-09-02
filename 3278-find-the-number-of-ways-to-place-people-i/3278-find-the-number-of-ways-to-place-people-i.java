class Solution {
    public int numberOfPairs(int[][] points) {
        int count = 0;

        for (int[] A : points) {
            int x1 = A[0], y1 = A[1];

            for (int[] B : points) {
                if (A == B) continue;
                int x2 = B[0], y2 = B[1];

                // A is upper-left of B (allowing line case)
                if (x1 <= x2 && y1 >= y2 && (x1 < x2 || y1 > y2)) {
                    boolean valid = true;

                    for (int[] C : points) {
                        if (C == A || C == B) continue;
                        int x3 = C[0], y3 = C[1];

                        if (x1 <= x3 && x3 <= x2 && y2 <= y3 && y3 <= y1) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) count++;
                }
            }
        }

        return count;
    }
}
