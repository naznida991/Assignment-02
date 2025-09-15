package pack2;

import java.util.Scanner;

public class Array_analyzer {
    public static void main(String[] args) {

        int sum = 0;
        int evenCount = 0;
        int oddCount = 0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];


        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        System.out.println("Sum = " + sum);


        double average = (double) sum / size;
        System.out.println("Average = " + average);


        int min = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Min = " + min);


        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Max = " + max);


        for (int i = 0; i < size; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Even Count = " + evenCount);
        System.out.println("Odd Count = " + oddCount);


        // reverse print
        System.out.println("Array in Reverse Order:");
        for (int i = size; i > 0; i--) {
            System.out.print(arr[i] + " ");
        }


    }
}
