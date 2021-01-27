package week1;

public class DayTwoHomework {
    public static void main(String[] args) {
        System.out.println("Day 2 Homework - Primitive Data and Operators");
        
        //Question One
        System.out.println("\n1.\tWrite program that can calculate the area of circle. You will need to create variables for the radius and the area.");
        areaOfaCircle(15); 
        System.out.println("\n\n2.\tWrite a program that can calculate the volume of a sphere.");
        volumeOfSphere(20);
        System.out.println("\n\n3.\tCreate a program that can solve the equation y = ax2+bx+c given a, b, c and x.");
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
