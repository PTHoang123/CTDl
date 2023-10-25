package lab5;

public class Array2D {
    public static int[][] add(int[][] a, int[][] b) { 
        int [][] result = new int[a.length][a[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
    public static int[][]subtract(int[][] a, int[][] b) { 
        int [][] result = new int[a.length][a[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;

    }
    public static int[][] multiply(int[][] a, int[][] b){
        int [][] result = new int[a.length][b[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b[0].length; j++){
                for(int k = 0; k < a[0].length; k++){
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
    public static int[][] transpose(int[][] a){ // TODO
        int [][] result = new int[a[0].length][a.length];
        for(int i = 0 ; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                result[j][i] = a[i][j];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] maxtrix1 = { { 1, 2,}
                            ,{ 3,4},
                             {5,6} };
        int[][] maxtrix2 = {{7,2},{5,3}};
        int[][] maxtrix3 = {{2,1},{3,1}};
        int[][] matrixAdd = add(maxtrix2, maxtrix3);
        for(int i = 0; i < matrixAdd.length; i++){
            for(int j = 0; j < matrixAdd[i].length; j++){
                System.out.print(matrixAdd[i][j] + " ");
            }
            System.out.println();
        }
        int[][] matrixSubtract = subtract(maxtrix2, maxtrix3);
        for(int i = 0; i < matrixSubtract.length; i++){
            for(int j = 0; j < matrixSubtract[i].length; j++){
                System.out.print(matrixSubtract[i][j] + " ");
            }
            System.out.println();
        }
        int[][] matrixMultiply = multiply(maxtrix1, maxtrix2);
        for(int i = 0; i < matrixMultiply.length; i++){
            for(int j = 0; j < matrixMultiply[i].length; j++){
                System.out.print(matrixMultiply[i][j] + " ");
            }
            System.out.println();
        }
        int[][] matrixTranpose = transpose(maxtrix1);
        for(int i = 0; i < matrixTranpose.length; i++){
            for(int j = 0; j < matrixTranpose[i].length; j++){
                System.out.print(matrixTranpose[i][j] + " ");
            }
            System.out.println();
        }

    }
}