package lab1;
public class MyArray {
    private int[] array;
    public MyArray(int[] array) { 
        this.array = array;
    }
    public int[] mirror(){
        int[] arrays = new int[this.array.length*2];
        for(int i = 0; i < this.array.length; i++){
        
            arrays[i] = this.array[i];
            arrays[arrays.length - 1 - i] = this.array[i];
        }
        return arrays;
    }
  
    public int[] removeDuplicated () {
        int[] arrays = new int[this.array.length];
        int count = 0;
        for(int i = 0; i < this.array.length; i++){
            boolean check = true;
            for(int j = 0; j < count; j++){
                if(this.array[i] == arrays[j]){
                    check = false;
                    break;
                }
            }
            if(check){
                arrays[count] = this.array[i];
                count++;
            }
        }
        int[] result = new int[count];
        for(int i = 0; i < count; i++){
            result[i] = arrays[i];
        }
        return result;
    }
    public int[] getMissingValues(){
        int count = 0;
        int [] array = new int[this.array.length];
        for (int i = 0; i < this.array.length - 1; i++){
            if(this.array[i] + 1  != this.array[i + 1]){
                array[count] = this.array[i] + 1;
                count++;
            }
        }
        int[] result = new int[count];
        for(int i = 0; i < count; i++){
            result[i] = array[i];
        }
        return result;
    }
    
    public int[] fillMissingValues(int k) {
        int[] arrays = new int[this.array.length];
        boolean[] check = new boolean[this.array.length];
        for (int i = 0; i < this.array.length ; i++) {
            arrays[i] = this.array[i];
            if (arrays[i] == -1 ) {
                int sum = 0;
                int count = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (count == k) {
                        break;
                    }
                    sum += arrays[j];
                    count++;
                }
                for (int j = i + 1; j < this.array.length; j++) {
                    if (count == k) {
                        break;
                    }
                    sum += arrays[j];
                    count++;
                }
                int average = sum / count;
                int minDiff = Math.abs(arrays[i - 1] - average);
                int nearestValue = arrays[i - 1];
                if (Math.abs(arrays[i + 1] - average) < minDiff) {
                    minDiff = Math.abs(arrays[i + 1] - average);
                    nearestValue = arrays[i + 1];
                }
                if (Math.abs(average - arrays[i - k]) < minDiff) {
                    nearestValue = arrays[i - k];
                }
                arrays[i] = nearestValue;
                check[i] = true;
            }
        }
        for(int i = 0; i < arrays.length - 1 ; i++){
            if(arrays[i+1] < arrays[i]){
                int sum = 0;
                int count = 0;
                for (int j = i ; j >= 0; j--) {
                    if (count == k || check[j]) {
                        break;
                    }
                    sum += arrays[j];
                    count++;
                }
                for (int j = i + 2; j < this.array.length; j++) {
                    if (count == k) {
                        break;
                    }
                    sum += arrays[j];
                    count++;
                }
                int average = sum / count;
                int minDiff = Math.abs(arrays[i] - average);
                int nearestValue = arrays[i];
                if (Math.abs(arrays[i + 2] - average) < minDiff ) {
                    minDiff =  Math.abs(arrays[i + 2] - average);
                    nearestValue = (int) Math.floor(arrays[i + 2]);
                }
                if (Math.abs(average - arrays[i + 1 - k ]) < minDiff)  {
                    nearestValue = (int) Math.floor(arrays[i + 1 - k ]);
                }
              

                arrays[i + 1] = nearestValue - 1;
                
            }
        }
        return arrays;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5}; 
        MyArray myArray = new MyArray(array);
        int[] arrays = myArray.mirror();
        for(int i = 0; i < arrays.length; i++){
            System.out.print(arrays[i] + " "  );
        }
        System.out.println('\n');
        int[] array1 = {1,3,5,1,3,7,9,8}; 
        MyArray myArray1 = new MyArray(array1);
        int[] arrays1 = myArray1.removeDuplicated();
        for(int i = 0; i < arrays1.length; i++){
            System.out.print(arrays1[i] + " ");
        }
        System.out.println('\n');
        int[] array2 = {1,2,3,5,6,7,9}; //output {4,8}
        MyArray myArray2 = new MyArray(array2);
        int[] arrays2 = myArray2.getMissingValues();
        for(int i = 0; i < arrays2.length; i++){
            System.out.print(arrays2[i] + " ");
        }
        System.out.println('\n');
        int[] array3 = {10,11,12,-1,14,10,17,19,20}; //output {10,11,12,12,14,16,17,19,20}
        MyArray myArray3 = new MyArray(array3);
        int[] arrays3 = myArray3.fillMissingValues(3);  
        for(int i = 0; i < arrays3.length; i++){
            System.out.print(arrays3[i] + " ");
        }
    }
}