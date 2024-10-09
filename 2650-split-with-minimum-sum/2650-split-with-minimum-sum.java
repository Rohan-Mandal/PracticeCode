class Solution {
    public int splitNum(int num) {
	int[] digit = new int[10];
	int count = 0;
	while(num > 0){
		digit[num % 10]++;
		count++;
		num /= 10;
	}
	int num1 = 0, num2 = 0;
	for(int i = 0; i <= 9; i++){
		while(digit[i] > 0){
			if(count % 2 == 0){
				num1 = num1 * 10 + i;
			} else{
				num2 = num2 * 10 + i;
		}
		count--;
		digit[i]--;
		}
	}
	return num1 + num2;
    }
}