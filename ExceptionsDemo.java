import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsDemo {
    public static void main(String[] args) {
        System.out.println("Mystery output:");
        System.out.println(mystery());
        
        System.out.println("\nRisky(0) output:");
        System.out.println(risky(0));
        
        System.out.println("\nRisky(2) output:");
        System.out.println(risky(2));
    }

    static int mystery() {
        try {
            System.out.println("A");
            return 1;
        } catch (Exception e) {
            System.out.println("B");
            return 2;
        } finally {
            System.out.println("C");
            return 3;
        }
    }

    static int risky(int x) {
        try {
            if (x == 0) throw new ArithmeticException();
            return 10 / x;
        } catch (ArithmeticException e) {
            System.out.println("caught");
            return -1;
        } finally {
            System.out.println("done");
        }
    }
    
    // Part c
    public static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }
    
    public static void withdraw(double balance, double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Balance too low");
        }
        balance -= amount;
    }
    
    // Part d
    public static void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
