package pack3;

public class Calculator {
    private int a;
    private int b;
    private int c;

    Calculator(int x, int y, int z) {
        a = x;
        b = y;
        c = z;
    }

    public int add() {
        return a + b;
    }

    public int subtract() {
        return a - b;
    }

    public int multiply() {
        return a * b;
    }

    public double divide() {
        if (b == 0) {
            System.out.println("Error");

        }
        return (double) a / b;
    }

    public int maxofThree() {
        int max = a;
        if (b > max) {
            max = b;
        } else if (c > max) {
            max = c;
        }
        return max;
    }

    public boolean isPrime() {
      boolean is_prime=true;

        for (int i = 2; i < a ; i++) {
            if (a % i == 0) {
                is_prime=false;
            }
        }
        return is_prime;
    }
}