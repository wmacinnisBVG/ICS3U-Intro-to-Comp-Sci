package week3;
public class WritingFunctions{
 public static void main(String[] args) {
     int x = 7;
     int y = 8;
     int z = sum(x, y);
     //System.out.print(z);

     addOne(x);
     //System.out.print(x);
     double x1, x2, y1, y2;
     x1=4;
     x2=7;
     y1=-2;
     y2=6;
     double slope = getSlope(x1,y1,x2,y2);
     System.out.print(slope);
 }
private static double getSlope(double x1, double y1, double x2, double y2){
    double deltaX = x2-x1;
    double deltaY = y2-y1;
    return deltaY/deltaX;
}
 private static int sum(int num1, int num2) {
     int result = num1 + num2; 
     return result;
 }
private static void addOne(int num1){
    num1++; 
}
}