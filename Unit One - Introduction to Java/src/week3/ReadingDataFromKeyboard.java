package week3;

import java.util.Scanner;

public class ReadingDataFromKeyboard {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
    }

    private static void exampleTwo() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a 5 diget int: ");
        int number = Integer.parseInt(in.nextLine());
        int sum = FunctionsAndScanner.getSum(number);
        System.out.println(sum);
        in.close();
    }

    private static void exampleOne() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your favorite color: ");
        String favoriteColor = in.nextLine();
        System.out.println(favoriteColor);
        in.close();
    }
}
