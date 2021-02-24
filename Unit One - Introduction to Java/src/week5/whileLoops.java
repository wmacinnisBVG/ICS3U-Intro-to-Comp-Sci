package week5;

import java.util.Scanner;

public class whileLoops {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = sum(1, 10);
        System.out.println(x);
        loopExampleTwo(in);
        System.out.println("Please enter a sentance. ");
        String sentance = in.nextLine();

      int  numVowels =  countVowels(sentance);
      System.out.println("There are "+numVowels+".");
    }


    private static int countVowels(String nextLine) {
        int numVowels = 0;
        int index = 0;
        while(index < text.length()){
            String letter = text.substring(index, index+1);
            if(letters.equalsIgnoreCase("a") || letters.equalsIgnoreCase("e") || letters.equalsIgnoreCase("i") || letters.equalsIgnoreCase("o") || letters.equalsIgnoreCase("u"))
        } 

    }

    private static void loopExampleTwo(Scanner in) {
        String mysteryColour = "red";
        String colour = null;
        while(colour == null || !mysteryColour.equalsIgnoreCase(colour)){
            System.out.print("What is the mystery colour? ");
            colour = in.nextLine();
        }

        System.out.println("I like that colour "+mysteryColour);
    }

    private static int sum(int start, int end) {
        int result = start;
        int i = 0; 
        while(i <= end){
            result += i;
            i++;

        }
        return result; 
    }
}
