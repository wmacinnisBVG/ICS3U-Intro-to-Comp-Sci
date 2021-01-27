package week1;

public class DayTwoHomework {
    public static void main(String[] args) {
        System.out.println("Day 2 Homework - Primitive Data and Operators");
        
        //Question One
        System.out.println("\n1.\tWrite program that can calculate the area of circle. You will need to create variables for the radius and the area.");
        areaOfaCircle(15); 

        //Question Two
        System.out.println("\n\n2.\tWrite a program that can calculate the volume of a sphere.");
        volumeOfSphere(20);

        //Question Three 
        System.out.println("\n\n3.\tCreate a program that can solve the equation y = ax2+bx+c given a, b, c and x.");
        solveYEquation(20, 30, 40, 20);

        //Question Four
        System.out.println("\n\n4.\tWrite a program to calculate the slope of a line give (x1, y1) and (x2,y2).");
        calculateSlope(10,20,30,40);

        //Question Five
        System.out.println("\n\n5.\tWrite a program that given the number of pennies, nickles, dimes, quarters, loonies and toonies calculates how much money the user has.");
        changeCalculator(10, 20, 30, 2, 4, 6);

        //Question Six
        System.out.println("\n\n6.\tMath.sqrt(x), where x is a value can be used to calculate the square root. Give an equation in the format from question 3.  Obtain the two roots.");
        calculateRoots(10, 15, 40, 50);
    }

    private static void calculateRoots(double a, double b, double c, double x) {
        double root1 = -b+Math.sqrt(b*b-4*a*c)/2*a;
        double root2 = -b-Math.sqrt(b*b-4*a*c)/2*a;
        System.out.print("Answers are: ");
        System.out.print(root1);
        System.out.print(" and ");
        System.out.print(root2);
    }

    private static void changeCalculator(int pennies, int nickles, int dimes, int quarters, int loonies, int toonies) {
        double total = 0.01*pennies+0.05*nickles+0.10*dimes+0.25*quarters+1*loonies+2*toonies;
        System.out.print("Your total is: ");
        System.out.print(total);
    }

    private static void calculateSlope(float x1, float y1, float x2, float y2) {
        float slope = y2-y1/x2-x1;
        System.out.print("Slope is: ");
        System.out.print(slope);
    }

    private static void solveYEquation(float a, float b, float c, float x) {
        float y = a*x*2+b*x+c;
        System.out.print("Answer: ");
        System.out.print(y);
    }

    private static void volumeOfSphere(double radius) {
        //Volume of a sphere 4/3πr3
        double volume = 1.33333333333*3.14*Math.pow(radius,3);
        System.out.print("\nThe volume of a sphere with a radius of ");
        System.out.print(radius);
        System.out.print(" is: ");
        System.out.print(volume);
    }

    private static void areaOfaCircle(double radius) {
        //Area of a circle A=πr2
        double area; 
        area = 3.14*radius*radius;
        System.out.print("\nThe area of a circle with a radius of ");
        System.out.print(radius);
        System.out.print(" is: ");
        System.out.print(area);

    }
}
