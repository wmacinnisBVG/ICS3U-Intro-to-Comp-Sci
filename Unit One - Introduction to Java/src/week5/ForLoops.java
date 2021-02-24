package week5;

import java.util.Scanner;

public class ForLoops {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int x = sum(1, 10);
        //System.out.println(x);
        //loopExampleTwo(in);
        //System.out.println("Please enter a sentance. ");
        //String sentance = in.nextLine();

      //int  numVowels =  countVowels(sentance);
      //System.out.println("There are "+numVowels+".");
       // drawRectangle(4,6,"*");
       ecoo2010(4,3,1,2);
    }


    private static void ecoo2010(int m, int n, int p, int q) {
       // T of frame
        for(int j=0; j<q; j++){
            for(int i=0; i<(n+2*p+2*q); i++){
                System.out.print("#");
            }
            System.out.println();
    
        }
        //Second line left
        for(int k=0; k<q; k++){
            System.out.print("##");
        }

    
                //Second line right
                for(int k=0; k<q; k++){
                    System.out.print("##");
                }
        
        //B of frame
        for(int j=0; j<q; j++){
            for(int i=0; i<(n+2*p+2*q); i++){
                System.out.print("#");
            }
            System.out.println();
    
        }
    }

    private static void drawRectangle(int width, int height, String symbol) {
        for(int row=0; row<height; row++){
            for(int col=0; col<width; col++){
                System.out.print(symbol);
            }
            System.out.println();
        }
      
    }

    private static int countVowels(String sentance) {
        return 0;
    }

    private static int sum(int start, int end) {
       int result = 0;
       for(int i = start; i <= end; i++){
            result += 1;
       }
       return result;
    }
}
