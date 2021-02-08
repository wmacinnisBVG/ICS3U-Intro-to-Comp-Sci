package week3;

public class FunctionsHomework {
    public static void main(String[] args) {
    //Question 1
       double total = salesTax(985.0);
        System.out.println("Total with tax: "+total);
    //Question 2
    double width = 4.5;
    double height = 2.3;
    double AreaAndPerimiter = findAandP(width, height);
    System.out.println("Area: "+AreaAndPerimiter);
    //Question 3
    double minutesInAYear = calculateMinutesInAYear();
        System.out.println(minutesInAYear);
    //Question 4
    double lightYears = lightInOneYear();
    System.out.println("Lightyears: "+lightYears);
    //Question 5 
    double NYYwinningPercentage = winsVsLosses(110, 44);
    System.out.println("New York Yankees Winning Percentage: "+NYYwinningPercentage);
    //Question 6
    double mass = 10;
    double velocity = 12;
    double monentum = findMomentum(mass, velocity);
    System.out.println("Moentum: "+ monentum);
    //Question 7
    int covertedIntoCelsius = FtoC(98);
    System.out.println("Celsius: "+covertedIntoCelsius);
    //Question 8
    findSquares(2);
    //Question 9
    double numOfItems = 3;
    double comission = findComission(numOfItems);
    System.out.println("They are owed: $"+comission);
    //Question 10
    double length = 10;
    double width1 = 20;
    double area = findArea(length, width1);
    System.out.println("Area is: "+area);
    double perimeter = findPer(length, width1);
    System.out.println("Perimeter is: "+perimeter);
    //Question 11
    double mass1 = 10;
    double speed = 2;
    double KEnergy = findKineticEnergy(mass1, speed);
    System.out.println("Kinetic Energy: "+KEnergy);
    }
    
    private static double findKineticEnergy(double mass1, double speed) {
        return (1/2)*mass1*Math.pow(speed,2);
    }

    private static double findPer(double length, double width1) {
        return length+length+width1+width1;
    }

    private static double findArea(double length, double width1) {
        return length*width1;
    }

    private static double findComission(double numOfItems) {
        return numOfItems*0.27;
    }

    private static void findSquares(int i) {
        System.out.println("The sqare root of "+i+" is: "+Math.sqrt(i));
        System.out.println("The sqare of "+i+" is: "+Math.pow(i, i));
    }

    private static int FtoC(int f) {
        return (f-32)*5/9;
    }

    private static double findMomentum(double mass, double velocity) {
        return mass*velocity;
    }

    private static double winsVsLosses(int wins, int losses) {
        double totalGamesPlayed = wins + losses;
        return (wins/totalGamesPlayed)*100;
    }

    private static double lightInOneYear() {
        return (3*Math.pow(10, 8))*31536000;
    }

    private static double findAandP(double width, double height) {
        
        return width*height;
    }

    private static double calculateMinutesInAYear() {
        double minutes = 365*24*60;

        return minutes;
    }

    private static double salesTax(double dpurchasePrice) {
        double tax = dpurchasePrice*0.055;
        double total = dpurchasePrice+tax;
        return total;
    }
}
