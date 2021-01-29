package week1;

public class StringConcatation {
    public static void main(String[] args) {
        //exampleOne();
        //exampleTwo();
        exampleThree();
    }

    private static void exampleThree() {
        int x = 4; 
        int y = 3; 
        System.out.println(x + "+" + y + " = " + (x + y));
        System.out.println(x + y + "=" + x+ " + " + y);

    }

    private static void exampleTwo() {
        int x = 7; 
        int y = 3; 
        int sum=x+y;
        System.out.print(x + "+" + y + "=" + sum);
    }

    private static void exampleOne() {
        int markOne = 90;
        int markTwo = 94;
        int markThree = 88;
        final int NUM_TESTS = 3; 
        double avg = (double)(markOne+markTwo+markThree)/NUM_TESTS; 
        System.out.println(avg);
    }
}
