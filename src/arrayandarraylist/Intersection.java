package arrayandarraylist;

public class Intersection {
    public static void intersection(int[] arr1, int[] arr2) {

        int[] sortedArray1 = sort(arr1, 0, arr1.length);
        int[] sortedArray2 = sort(arr2, 0, arr2.length);
        int i = 0, j = 0;

        if(arr1[i] < arr2[j]){
            i++;
        }
        else if(arr2[i] < arr1[j]){
            j++;
        }
        else{
            System.out.println(arr1[i] +"");
        }

    }

    public  static int[] sort(int[] input, int start, int end){
        if(input.length == 1){
            return input;
        }
        int middle = input.length / 2;
        int[] left = sort(input,0, middle);
        int[] right = sort(input, middle + 1, input.length);

        return merge(left, right);
    }

    public static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < first.length && j < second.length) {
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while(i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;

    }
}
