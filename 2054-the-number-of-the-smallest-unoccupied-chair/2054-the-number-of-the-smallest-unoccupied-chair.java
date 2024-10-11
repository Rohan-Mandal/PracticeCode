import java.util.*;

class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        // Priority queue to store chairs in use, sorted by departure time
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));

        int targetArrivalTime = times[targetFriend][0];

        // Sort the times array by arrival time
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        // TreeSet to track available chair numbers, ordered to retrieve the smallest chair number
        TreeSet<Integer> availableChairs = new TreeSet<>();

        int lastChair = 0;

        // Iterate through each friend's arrival and departure times
        for (int[] time : times) {
            int arrival = time[0];
            int depart = time[1];
            int currSeat;

            // Release chairs that are now free
            while (!pq.isEmpty() && pq.peek().getKey() <= arrival) {
                availableChairs.add(pq.poll().getValue());
            }

            // Assign a chair to the current friend
            if (availableChairs.isEmpty()) {
                currSeat = lastChair;
                lastChair++;
            } else {
                currSeat = availableChairs.pollFirst(); // Get the smallest available chair
            }

            // Add the occupied chair with its departure time to the priority queue
            pq.offer(new AbstractMap.SimpleEntry<>(depart, currSeat));

            // Check if the current friend is the target friend
            if (arrival == targetArrivalTime) {
                return currSeat;
            }
        }

        return -1; // This case should never occur based on the problem constraints
    }
}
