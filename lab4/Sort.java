package lab4;

public class Sort {
    public static void selectionSort (int[] array){
        for(int i = 0 ; i < array.length - 1 ; i++){
            int min = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }
    public static void bubleSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp; 
                }
            }
        }
    }
    public static void insertionSort(int[] array){
        for(int i = 1 ; i < array.length; i++){
            int temp = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > temp){
                array[j + 1] = array[j]; 
                j--;
            }
             array[j + 1] = temp;
        }
    }
    public static void merge(int[] array, int[] left, int[] right){
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                array[k++] = left[i++];
            }else{
                array[k++] = right[j++];
            }
        }
        while(i < left.length){
            array[k++] = left[i++];
        }
        while(j < right.length){
            array[k++] = right[j++];
        }
    }
    public static void mergeSort(int[] array){
        if(array.length < 2){
            return;
        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        for(int i = 0; i < mid; i++){
            left[i] = array[i];
        }
        for(int i = mid; i < array.length; i++){
            right[i - mid] = array[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
     }
     public static void quickSort(int array[], int low, int high){
        if(low < high){
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
        
     }
     public static int partition(int array[], int low, int high){
        int pivot = getPivot(array);
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(array[j] < pivot){
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp; 
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp; 
        return i + 1;
     }
     private static int getPivot(int[] array) {
            return getPivot_MedianOfThree(array);
     }


     private static int getPivot_MedianOfThree(int[] array) {
        int first = array[0];
        int last = array[array.length - 1];
        int middle = array[array.length / 2];
        if(first > last){
            if(first < middle){
                return first;
            }else if(last > middle){
                return last;
            }else{
                return middle;
            }
        }else{
            if(last < middle){
                return last;
            }else if(first > middle){
                return first;
            }else{
                return middle;
            }
        }
        
    }
    private static int getPivot_First(int[] array) {
        return array[0];
    }
    private static int getPivot_Last(int[] array) {
        return array[array.length - 1];
    }
    private static int getPivot_Random(int[] array) {
        return array[(int)(Math.random() * array.length)];
    }
    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};
        selectionSort(array);
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        System.out.println("Buble Sort");
        int[] array2 = {3,7,2,1,5};
        bubleSort(array2);
        for(int i = 0; i < array2.length; i++){
            System.out.println(array2[i]);
        }
        System.out.println("Insertion Sort");
        int[] array3 = {3,7,2,1,5,9,8,6,4};
        insertionSort(array3);
        for(int i = 0; i < array3.length; i++){
            System.out.println(array3[i]);
        }
         System.out.println("Merge Sort");
        int[] array4 = {3,7,2,1,5,9,8,6,4};
        mergeSort(array4);
        for(int i = 0; i < array4.length; i++){
            System.out.println(array4[i]);
        }
        System.out.println("Quick Sort");
        int[] array5 = {3,7,2,1,5,9,8,6,4};
        quickSort(array5, 0, array5.length - 1);
        for(int i = 0; i < array5.length; i++){
            System.out.println(array5[i]);
        }
    }

}
