package Recursion;
public class MinimumInArray{

    public static int findMinimum(int[] array, int startIndex){
        if(startIndex >= array.length){
            return Integer.MAX_VALUE;
        }
        int minElement = findMinimum(array, startIndex + 1);
        if(array[startIndex] < minElement){
            return array[startIndex];
        }
        else{
            return minElement;
        }
    }

    public static void findMinimumPrint(int[] array){
        int result =  findMinimum(array, 0);
        System.out.println(result);
    }

    public static void printMinimum(int[] array, int startIndex, int minSoFar){
        if(startIndex >= array.length){
            System.out.println(minSoFar);
            return;
        }
        int newMin = minSoFar;
        if(array[startIndex] < minSoFar){
            newMin = array[startIndex];
        }

        printMinimum(array, startIndex + 1, newMin);
    }
    public static void main(String[] args) {
        int[] arr = {1,5,6,19,10,23,-1};
        printMinimum(arr, 0,Integer.MAX_VALUE);
       
    }
}