package week5;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sentance = "BASEBALL IS THE BEST SPORT OUT THERE";
        String usedLetters = "ASTGQ";

        String guess = getLetter(in, usedLetters);
        encryptMessage(sentance, usedLetters);
        in.close();
    }

    private static String getLetter(Scanner in, String usedLetters) {
        String letter = "";
        boolean isValid = false; 
        String validCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYXabcdefghijklmnopqrstuvwxyz";
        while(!isValid){
            System.out.print("Used Letters: " + displayUsedLetters(usedLetters));
            System.out.println();
            System.out.print("Please enter a letter: ");
            letter = in.nextLine();
            if(letter.length() == 1 && validCharacters.indexOf(letter) >= 0 && usedLetters.indexOf(letter) < 0){
                boolean validInput = true;
            } else {
                System.out.println("Invalid Guess: Only letters are allowed and you cannot guess a letter you hav already chosen.")
            }
        }
        return letter;
    }
    private static String displayUsedLetters(String usedLetters){
        String letters ="";
        for(int i=0; i < usedLetters.length(); i++){
            letters += usedLetters.substring(i, i+1);
        }
        return letters; 
    }
    private static void encryptMessage(String sentance, String usedLetters) {
        for(int i = 0; i < sentance.length(); i++){
            String temp = sentance.substring(i, i+1);
            if(temp.equals(" ")){
                System.out.print("/ ");
            } else if(usedLetters.indexOf(temp) >= 0){
                System.out.print("_ ");
            }    
             else {
                System.out.print(temp + " ");
            }
        }
    }

}
