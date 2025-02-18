class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        char[] num = new char[n + 1];
        
        // Fill num with '1' to 'n+1'
        for (int i = 0; i <= n; i++) {
            num[i] = (char) ('1' + i);
        }
        
        // Iterate through the pattern and swap adjacent numbers when 'D' is encountered
        for (int i = 0; i < n; i++) {
            if (pattern.charAt(i) == 'D') {
                int j = i;
                // Find the end of the 'D' sequence and reverse that part
                while (j < n && pattern.charAt(j) == 'D') {
                    j++;
                }
                reverse(num, i, j);
                i = j; // Move the pointer ahead
            }
        }
        
        return new String(num);
    }
    
    // Reverse a portion of the array from 'start' to 'end'
    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
