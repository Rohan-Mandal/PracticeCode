class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert to long to avoid overflow (e.g., Integer.MIN_VALUE case)
        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);

        // Integer part
        result.append(dividend / divisor);
        long remainder = dividend % divisor;

        // If no remainder, return the integer part
        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        // Map to remember when a remainder first appeared
        Map<Long, Integer> remainderMap = new HashMap<>();

        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                // Repeating remainder found -> insert '(' at the earlier index
                int index = remainderMap.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }

            // Store position of this remainder in result
            remainderMap.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / divisor);
            remainder %= divisor;
        }

        return result.toString();
    }
}
