package week1;

public class VariablesAndAssignmentOperator {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
    }

    private static void exampleTwo() {
        double x = 2.5; 
        double y = 2.1;
        double sum = x+y;

        System.out.println(sum);
    }

    private static void exampleOne() {
        int numberOne;
        numberOne = 10;
        System.out.println(numberOne);
    }
}
