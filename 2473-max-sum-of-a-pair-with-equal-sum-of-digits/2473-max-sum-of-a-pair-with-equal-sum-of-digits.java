class Solution {
    public int maximumSum(int[] nums) {
        int result = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            int digitSum = sumOfDigit(num);

            if(map.containsKey(digitSum)){
                result = Math.max(result, num + map.get(digitSum));
            }

            map.put(digitSum, Math.max(map.getOrDefault(digitSum, 0), num));
        }
        return result;
    }


    private int sumOfDigit(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}