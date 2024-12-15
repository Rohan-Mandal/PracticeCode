class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to store classes based on their incremental gain (max-heap)
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Populate the priority queue with initial data
        for (int[] cls : classes) {
            int pass = cls[0];
            int total = cls[1];
            double gain = gainFromExtraStudent(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        // Assign extra students
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            pass++;
            total++;
            pq.offer(new double[]{gainFromExtraStudent(pass, total), pass, total});
        }

        // Calculate the final average pass ratio
        double totalRatio = 0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalRatio += (double) pass / total;
        }

        return totalRatio / classes.length;
    }

    // Method to calculate the incremental gain of adding one student to a class
    private static double gainFromExtraStudent(int pass, int total) {
        return (double) (pass + 1) / (total + 1) - (double) pass / total;
    }
}