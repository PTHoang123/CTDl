package lab1;
public class MyCaesar {
    public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F',
    'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
    'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private int n;
    public MyCaesar(int shiftSteps) {
     this.n = shiftSteps;
    }
    public char encryptChar(char c) { 
        int index = -1;
        for(int i = 0; i < ALPHABET.length; i++){
            if(c == ALPHABET[i]){
                index = i;
                break;
            }
        }
        if(index == -1){
            return c;
        }
        int newIndex = (index + this.n) % ALPHABET.length;
        return ALPHABET[newIndex];
    }
    public String encrypt(String input) { 
        String result = new StringBuilder(input).toString();
        for(int i = 0; i < input.length(); i++){
            result = result.replace(input.charAt(i), encryptChar(input.charAt(i)));
        }
        return result;
    }
    public char decryptChar(char c){
        int index = -1;
        for(int i = 0; i < ALPHABET.length; i++){
            if(c == ALPHABET[i]){
                index = i;
                break;
            }
        }
        if(index == -1){
            return c;
        }
        int newIndex = (index - this.n) % ALPHABET.length;
        if(newIndex < 0){
            newIndex = ALPHABET.length + newIndex;
        }
        return ALPHABET[newIndex];
    }
    public String decrypt(String input) { 
        String result = new StringBuilder(input).toString();
        for(int i = 0; i < input.length(); i++){
            result = result.replace(input.charAt(i), decryptChar(input.charAt(i)));
        }
        return result;
    }
    public static void main(String[] args) {
        MyCaesar myCaesar = new MyCaesar(3);
        System.out.println(myCaesar.encryptChar('A'));
        System.out.println(myCaesar.encryptChar('B'));
        System.out.println(myCaesar.encryptChar('C'));
        System.out.println(myCaesar.encryptChar('D'));
        System.out.println(myCaesar.encryptChar('E'));
        System.out.println(myCaesar.encryptChar('F'));
        System.out.println(myCaesar.encryptChar('G'));
        System.out.println(myCaesar.encryptChar('H'));
        System.out.println(myCaesar.encryptChar('I'));
        System.out.println(myCaesar.encryptChar('J'));
        System.out.println(myCaesar.encryptChar('K'));
        System.out.println(myCaesar.encryptChar('L'));
        System.out.println(myCaesar.encryptChar('M'));
        System.out.println(myCaesar.encryptChar('N'));
        System.out.println(myCaesar.encryptChar('O'));
        System.out.println(myCaesar.encryptChar('P'));
        System.out.println(myCaesar.encryptChar('Q'));
        System.out.println(myCaesar.encryptChar('R'));
        System.out.println(myCaesar.encryptChar('S'));
        System.out.println(myCaesar.encryptChar('T'));
        System.out.println(myCaesar.encryptChar('U'));
        System.out.println(myCaesar.encryptChar('V'));
        System.out.println(myCaesar.encryptChar('W'));
        System.out.println(myCaesar.encryptChar('X'));
        System.out.println(myCaesar.encryptChar('Y'));
        System.out.println(myCaesar.encryptChar('Z'));
        System.out.println(myCaesar.encryptChar('a'));
        System.out.println(myCaesar.encryptChar('b'));
        System.out.println(myCaesar.encryptChar('c'));
        System.out.println(myCaesar.encryptChar('d'));
        System.out.println(myCaesar.encryptChar('e'));
        System.out.println(myCaesar.encryptChar('f'));
        System.out.println(myCaesar.encryptChar('g'));
        System.out.println(myCaesar.encryptChar('h'));
        System.out.println(myCaesar.encryptChar('i'));
        System.out.println(myCaesar.encryptChar('j'));
        System.out.println(myCaesar.encryptChar('k'));
        System.out.println(myCaesar.encryptChar('l'));
        System.out.println(myCaesar.encryptChar('m'));
        System.out.println(myCaesar.encryptChar('n'));
        System.out.println(myCaesar.decryptChar('o'));
        System.out.println(myCaesar.decryptChar('p'));
        System.out.println("decrypt ");
        System.out.println(myCaesar.decryptChar('q'));
        System.out.println(myCaesar.decryptChar('R'));
        System.out.println(myCaesar.decryptChar('s'));
        System.out.println(myCaesar.decryptChar('T'));
        System.out.println(myCaesar.decryptChar('u'));
        System.out.println(myCaesar.decryptChar('v'));
        System.out.println(myCaesar.decryptChar('W'));
    }
}
