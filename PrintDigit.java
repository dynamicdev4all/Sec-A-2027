public class PrintDigit {

    static void printRevDigits(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        printRevDigits(n - 1);
    }
    static void printDigits(int n) {
        if (n <= 0) {
            return;
        }
        printDigits(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {

    }
}