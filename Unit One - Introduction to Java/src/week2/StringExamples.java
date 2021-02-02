package week2;

public class StringExamples {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
        exampleThree();
    }

    private static void exampleThree() {
        String s1 = new String("Steve");
        String s2 = new String("Steve");
        String s3 = "Steve";
        String s4 = "Steve";
        System.out.println(s1.equals(s2));
        
    }

    private static void exampleTwo() {
        String courseCode = "ICS3U AP";
        int x = courseCode.length();
        System.out.print(x);
    }

    private static void exampleOne() {
        String simpleText = "This is  a string.";
        System.out.print(simpleText);
    }
}
