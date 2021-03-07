package week6;

import java.util.Scanner;

public class ThreeCardPoker {

  private static final int HEARTS = 0;
  private static final int DIAMONDS = 1;
  private static final int CLUBS = 2;
  private static final int SPADES = 3;
  private static final int NUM_SUITS = 4;
  private static final int NUM_FACES = 13;
  private static final int JACK = 11;
  private static final int QUEEN = 12;
  private static final int KING = 13;
  private static final int ACE = 14;

	private static final int STRAIGHT_FLUSH = 40;
	private static final int THREE_OF_A_KIND = 30;
	private static final int STRAIGHT = 6;
	private static final int FLUSH = 3;
	private static final int PAIR = 1;
  private static final int HIGH_CARD = 0;

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    System.out.print("(Ante wager) ");
    int anteWager = getWager(in);
    boolean pairPlusWagerCheck = checkPairPlusWager(in);
    String playerHand = dealCards();
    String dealerHand = dealCards();
    int pairPlusWager = 0;
    if(pairPlusWagerCheck == true){
      System.out.print("(Pair plus wager) ");
      pairPlusWager = getWager(in);
      System.out.println("Your pair plus wager is: $"+pairPlusWager);
    } else {
      System.out.println("You did not bet on a pair plus wager.");
    }
    System.out.println("Your ante wager is: $"+anteWager);
    System.out.println("Your play wager is: $"+anteWager);
    System.out.println("Your cards are: " + playerHand);

    boolean play = playGame(in);

    if(play == true){
        int playWager = anteWager; 
        System.out.println("");
        System.out.println("Your cards are: " + playerHand);
        System.out.println("Your ante wager is: $"+anteWager);
        System.out.println("Your pair plus wager is: $"+pairPlusWager);
        System.out.println("Your play wager is: $"+playWager);
        System.out.println("-----------");
        System.out.println("Dealers cards are: " + dealerHand);
        boolean dealersHandCheck = checkDealersHand(dealerHand);
        if(dealersHandCheck == true){
    String whichHandIsBetter = checkCards(playerHand, dealerHand);
    System.out.println(whichHandIsBetter);
        if(whichHandIsBetter.equals("Dealer")){
          int totalLosses = 0; 
          System.out.println("Oh no! You lost, the dealers hand was better than yours.");
          if(pairPlusWagerCheck == true){
            int pairPlusValue = checkHandValue(playerHand);
            int pairPlusWinnings = pairPlusValue * pairPlusWager;
            System.out.println("Your pair plus winnings are: $"+ pairPlusWinnings);
            if(pairPlusWinnings == 0){
              totalLosses += pairPlusWager;
            } else {
              totalLosses -= pairPlusWinnings; 
            }
          }
          totalLosses += anteWager*2; 
          System.out.println("Your total losses are: $"+totalLosses);
        } else if(whichHandIsBetter.equals("Player")){
          int totalWinnings = 0;
          System.out.println("Congratulations! Your hand was better than the dealers hand. ");
          if(pairPlusWagerCheck == true){
            int pairPlusValue = checkHandValue(playerHand);
            int pairPlusWinnings = pairPlusValue * pairPlusWager;
            System.out.println("Your pair plus winnings are: $"+ pairPlusWinnings);
            totalWinnings += pairPlusWinnings; 
          }
          totalWinnings += anteWager*2;
          System.out.println("Your total winnings are: $"+totalWinnings);
        } else if(whichHandIsBetter.equals("Tie")){
          int totalLosses = 0; 
          if(pairPlusWagerCheck == true){
            int pairPlusValue = checkHandValue(playerHand);
            int pairPlusWinnings = pairPlusValue * pairPlusWager;
            System.out.println("Your pair plus winnings are: $"+ pairPlusWinnings);
          }
          System.out.println("There was a push (tie)! You still loose your ante wager $"+anteWager+" but you get your play wager returned. ");

        } else {
          System.out.println("ERROR");
          System.exit(0);
        }

        } else {
          int payout = playWager;
          System.out.println("Dealer did not qualify, your play wager has been returned, but you have lost your ante wager. ");
          System.out.println("Payout: $"+payout);
        }
    } else {
      int totalLosses = pairPlusWager+(anteWager*2);
      System.out.println("You folded: You lost $"+totalLosses);
   
    }

    in.close();
  }
  
  private static String checkCards(String playerHand, String dealerHand) {
    //players cards
    int playerHandValue = checkHandValue(playerHand);
    //dealer cards 
    int dealerHandValue = checkHandValue(dealerHand);
    if(dealerHandValue > playerHandValue){
      return "Dealer";
    } else if(dealerHandValue < playerHandValue){
      return "Player";
    } else if(dealerHandValue == playerHandValue){
      int playerHighCard = getHighCardValue(playerHand); 
      int dealerHighCard = getHighCardValue(dealerHand);
    if(playerHighCard > dealerHighCard){
      return "Player";
    } else if(playerHighCard < dealerHighCard) {
      return "Dealer";
    } else {
      return "Tie";
    }
    } else {
      return null;
    }
  }

  private static int getHighCardValue(String hand) {
    int spaceLocation1 = hand.indexOf(" ");
    String lastTwoCards = hand.substring(spaceLocation1+1, hand.length()-1);
    int spaceLocation2 = lastTwoCards.indexOf(" ");
    String card3 = lastTwoCards.substring(spaceLocation2+1, lastTwoCards.length());
    String card2 = lastTwoCards.substring(0, spaceLocation2);
    String card1 = hand.substring(0,spaceLocation1);
    int card1Face = getFace(card1);
    int card2Face = getFace(card2);
    int card3Face = getFace(card3);
    if(card1Face >= card2Face && card1Face >= card3Face){
      return card1Face; 
    } else if(card2Face >= card1Face && card2Face >= card3Face){
      return card2Face;
    } else {
      return card3Face;
    }
  }

  private static int checkHandValue(String hand) {
    int spaceLocation1 = hand.indexOf(" ");
    String lastTwoCards = hand.substring(spaceLocation1+1, hand.length()-1);
    int spaceLocation2 = lastTwoCards.indexOf(" ");
    String card3 = lastTwoCards.substring(spaceLocation2+1, lastTwoCards.length());
    String card2 = lastTwoCards.substring(0, spaceLocation2);
    String card1 = hand.substring(0,spaceLocation1);
    int card1Face = getFace(card1);
    String card1Suit = getSuit(card1);
    int card2Face = getFace(card2);
    String card2Suit = getSuit(card2);
    int card3Face = getFace(card3);
    String card3Suit = getSuit(card3);
    if(card1Suit.equals(card2Suit) && card2Suit.equals(card3Suit) && card1Face-card2Face == 1 && card2Face-card3Face == 1 || card1Suit.equals(card2Suit) && card2Suit.equals(card3Suit) && card3Face-card2Face == 1 && card2Face-card1Face == 1){
      return STRAIGHT_FLUSH;
    } else if(card1Face == card2Face && card2Face == card3Face){
      return THREE_OF_A_KIND;
    } else if(card3Face-card2Face == 1 && card2Face-card1Face == 1){
      return STRAIGHT; 
    } else if(card1Suit.equals(card2Suit) && card2Suit.equals(card3Suit)){
      return FLUSH;
    } else if(card1Face == card2Face || card2Face == card3Face || card1Face == card3Face){
      return PAIR;
    } else {
      return HIGH_CARD;
    }
    
  }

  private static String getSuit(String card) {
    return card.substring(card.length()-1);
  }

  private static int getFace(String card) {
    String face = card.substring(0,card.length()-1);
    if(face.equals("A")){
      return 14;
    } else if(face.equals("K")){
      return 13;
    } else if(face.equals("Q")){
      return 12;
    } else if(face.equals("J")){
      return 11; 
    } else {
      return Integer.parseInt(face);
    }
  }

  private static boolean checkDealersHand(String dealerHand) {
    if(dealerHand.indexOf('Q') >= 0 || dealerHand.indexOf('K') >= 0 || dealerHand.indexOf('A') >= 0){
        return true;
    } else {
      return false;
    }
 
  }

  private static boolean checkPairPlusWager(Scanner in) {
    String temp = "";
    while (!(temp.equalsIgnoreCase("Y") || temp.equalsIgnoreCase("YES") || temp.equalsIgnoreCase("N")
        || temp.equalsIgnoreCase("NO"))) {
            System.out.println("");
      System.out.print("Would you like to bet a pair plus wager? (Y/N)");
      temp = in.nextLine();
      temp = temp.toLowerCase();
    }
    return temp.indexOf("y") >= 0;
  }

  private static boolean playGame(Scanner in) {
    String temp = "";
    while (!(temp.equalsIgnoreCase("Y") || temp.equalsIgnoreCase("YES") || temp.equalsIgnoreCase("N")
        || temp.equalsIgnoreCase("NO"))) {
            System.out.println("");
      System.out.print("Do you want to play? (Y/N)");
      temp = in.nextLine();
      temp = temp.toLowerCase();
    }
    return temp.indexOf("y") >= 0;

  }
  private static int getWager(Scanner in) {
    int wager = 0;
    System.out.print("Please enter your wager (50 - 100): ");
    String wagerAsText = in.nextLine();
    boolean validInput = false;
    while (!validInput) {
      try {
        wager = Integer.parseInt(wagerAsText);
        
        if(wager > 49 && wager < 101){
            validInput = true;
        } else {
            System.out.print("Please enter a valid wager (50-100): ");
            wagerAsText = in.nextLine();
            }
      } catch (NumberFormatException ex) {
        System.out.print("Please enter a valid wager (50-100): ");
        wagerAsText = in.nextLine();
      }
    }
    return wager; 
  }

  private static String dealCards() {
    String cards = "";

    for (int i = 0; i < 3; i++) {
      Boolean hasCard = false;
      while (!hasCard) {
        String card = getCard();
        if (isUnique(cards, card)) {
          cards += card + " ";
          hasCard = true;
        }
      }
    }
    return cards;
  }

  private static String getCard() {
    return generateFace() + generateSuit();
  }

  private static String generateSuit() {
    int suit = (int) (Math.random() * NUM_SUITS);
    if (suit == HEARTS)
      return "H";
    else if (suit == DIAMONDS)
      return "D";
    else if (suit == CLUBS)
      return "C";
    else if (suit == SPADES)
      return "S";
    else
      return null;
  }

  private static String generateFace() {
    int face = (int) (Math.random() * NUM_FACES + 2);
    if (face >= 2 && face <= 10)
      return "" + face;
    else if (face == JACK)
      return "J";
    else if (face == QUEEN)
      return "Q";
    else if (face == KING)
      return "K";
    else if (face == ACE)
      return "A";
    else
      return null;
  }

  public static boolean isUnique(String playerHand, String card) {
    return playerHand.indexOf(card) == -1;
  }

}
