package lab3;

import java.util.Arrays;

public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    public int iterativeLinearSearch(int target) {
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public int recursiveLinearSearch(int target, int index) {
        if (index == array.length) {
            return -1;
        }
        if (target == array[index]) {
            return index;
        }
        return recursiveLinearSearch(target, index + 1);

    } 
    public int iterativeBinarySearch(int target) {
        Arrays.sort(this.array);
        int left = 0;
        int right = this.array.length -1 ;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == this.array[mid]) {
                return mid;
            } else if (target < this.array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
        // rest of the code
    }
    public int recursiveBinarySearch(int target, int left, int right){
        Arrays.sort(this.array);
        while(left <= right){
            int mid = (left + right)/2;
            if(target == this.array[mid]){
                return mid;
            }
            if(target < this.array[mid]){
                return recursiveBinarySearch(target, left, mid - 1);
            }
            if(target > this.array[mid]){
                return recursiveBinarySearch(target, mid + 1, right);
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        MyArray myArray = new MyArray(array);
        System.out.println(myArray.iterativeLinearSearch(3));
        System.out.println(myArray.recursiveLinearSearch(3, 0));
        System.out.println(myArray.iterativeBinarySearch(3));
        System.out.println(myArray.recursiveBinarySearch(3, 0, array.length - 1));
    }

}

	