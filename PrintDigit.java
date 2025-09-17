public class PrintDigit {

    static void printRevDigits(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        printRevDigits(n - 1);
    }

    public static void main(String[] args) {

    }
}