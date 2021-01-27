package week1;

public class DayTwoHomework {
    public static void main(String[] args) {
        System.out.println("Day 2 Homework - Primitive Data and Operators");
        
        //Question One
        System.out.println("\n1.\tWrite program that can calculate the area of circle. You will need to create variables for the radius and the area.");
        questionOne(15); 
    }

    private static void questionOne(double radius) {
        //Area of a circle A=πr2
        double area; 
        area = 3.14*radius*radius;
        System.out.print("The area of a circle with a radius of ");
        System.out.print(radius);
        System.out.print(" is: ");
        System.out.print(area);

    }
}
