package lab2;

public class Task1_1 {
	public static int getSn1 (int n) {
	
		if(n == 1) {
			return 1;
		}
		if(n < 0 ) {
			return 0;
		}
		
	
		
		return (int) (getSn1(n -1) + Math.pow(-1, n+1)*n) ;
	
	}
	public static int giaiThua (int n) {
		int result = n;
		for(int i = n ; i > 1 ; i-- ) {
			result*=i -1;
		}
		return result;
	}
	public static int getSn2 (int n) {
		if (n ==1) {
			return 1;
		}
		if(n < 0) {
			return 0;
		}
	
		return  getSn2(n-1) + giaiThua(n) ;
	} 
	
	public static int getSn3 (int n) {
		if(n == 1) {
			return 1;
		} 
		if(n < 0 ) {
			return 0;
		}
		return (int) (getSn3(n-1) + Math.pow(n, 2)) ;
	}
	public static int calculate(int n) {
        int result = 1;
        if (n == 1) {
            return 1;
        }
        
        for (int i = 2; i <= n*2; i += 2) {
            result *= i;

        }
        System.out.println(result + " " + n);
        return 1 / result;
    }
    // S(n)=1+1/2+1/(2.4)+1/(2.4.6)+...+1/(2.4.6.2n)
    public static int getSn4(int n) {
        if (n == 1) {
            return 1;
        }
        return  calculate(n) + getSn4(n - 1) ;
    }
	public static int getFibonacci(int n ) {
		if (n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return getFibonacci(n - 1) + getFibonacci(n -2 );
		
	}
	public static void printFibonacci (int n ) {
		int fibonacci = getFibonacci(n);
		for(int i = 0 ; i < fibonacci ; i++) {
            System.out.println(getFibonacci(i));
        }
	}
	public static int[] generateNextRow(int [] prevRow) {
		int[] nextRow = new int[prevRow.length + 1];
        nextRow[0] = 1;
        nextRow[nextRow.length - 1] = 1;
        for(int i = 1 ; i < nextRow.length - 1 ; i++) {
            nextRow[i] = prevRow[i-1] + prevRow[i];
        }
        return nextRow;
	} 
	public static int[] getPascal (int n) {
		if(n == 1 ) {
			return new int[] {1};	
		}
		else {
			int[] preRow = getPascal(n-1);
			return generateNextRow(preRow);
		}
	}
	 
	public static void printPascal(int row) {
        for (int i = 1; i <= row; i++) {
            int[] result = getPascal(i);
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
    }
    public static void moveTower(int disk, char source , char dest, char spare){
        if(disk == 1){
            System.out.println("Move disk 1 from " + source + " to " + dest);
        }
        else{
            moveTower(disk - 1, source, spare, dest);
            System.out.println("Move disk " + disk + " from " + source + " to " + dest);
            moveTower(disk - 1, spare, dest, source);
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSn1(5));
		System.out.println(getSn2(4));
		System.out.println(getSn3(4));
        System.out.println(getSn4(4));
		printFibonacci(6);
        printPascal(5);
        moveTower(3, 'A', 'C', 'B');

	}

}