import java.util.Scanner;

// Клас чисел Фібоначі
class FibonacciNumber {
    private int index;
    private int value;

    /**
     *
     * @param index Index of a Fibonacci number.
     * @param value Value of the same number.
     */
    public FibonacciNumber(int index, int value) {
        this.index = index;
        this.value = value;
    }

    /**
     *
     * @return Returns index.
     */
    public int getIndex() {
        return index;
    }

    /**
     *
     * @return Returns value.
     */
    public int getValue() {
        return value;
    }

    // Перевірка на умову

    /**
     *
     * @return Returns true or false based on the task.
     */
    public boolean isCubePlusOne() {
        double w = Math.cbrt(value - 1);
        return (w * w * w + 1) == value;
    }
}

public class Main {

    /**
     * Calculates Fibonacci number.
     * @param n Index of the number.
     * @return Returns a number.
     */
    public static int fibonacci(int n) {
        if (n < 1) {
            System.out.println(1);
            return 1;
        }
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println(b);
        return b;
    }

    /**
     * Main function
     * @param args Classic argument for the main function.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість чисел Фібоначчі (N): ");
        int N = scanner.nextInt();

        FibonacciNumber[] fibonacciNumbers = new FibonacciNumber[N];

        // Генеруємо перші N чисел Фібоначчі
        for (int i = 0; i < N; i++) {
            int fibValue = fibonacci(i);
            fibonacciNumbers[i] = new FibonacciNumber(i, fibValue);
        }

        // Перевіряємо, які з них можна записати у формі w^3 + 1
        System.out.println("Числа Фібоначчі, які можна представити як w^3 + 1:");
        for (FibonacciNumber fib : fibonacciNumbers) {
            if (fib.isCubePlusOne()) {
                System.out.println("Число Фібоначчі F(" + fib.getIndex() + ") = " + fib.getValue());
            }
        }
    }
}