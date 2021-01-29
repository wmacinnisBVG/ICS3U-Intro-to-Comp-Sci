package week1;

public class UsingBuiltInFunctions {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
        displayRandomNumber(6, 12);
    }

    private static void displayRandomNumber(int lower, int upper) {
        int randomNumber = (int)(Math.random()*(upper-lower+1))+lower;
        System.out.print(randomNumber);
    }

    private static void exampleTwo() {
        //double randomNumber = Math.random(); 
    }

    private static void exampleOne() {
        double x = 2.0;
        double y = Math.sqrt(x);

        double z = Math.pow(x, 2);
    }
}
