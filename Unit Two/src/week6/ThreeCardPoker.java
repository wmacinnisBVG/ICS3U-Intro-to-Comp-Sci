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
          System.out.println("Dealer qualifies. ");
    String whichHandIsBetter = checkCards(playerHand, dealerHand);
    System.out.println(whichHandIsBetter);

        } else {
          int payout = playWager;
          System.out.println("Dealer did not qualify, your play wager has been returned, but you have lost your ante wager. ");
          System.out.println("Payout: $"+payout);
        }
    } else {
      int totalLosses = pairPlusWager+anteWager;
      System.out.println("You folded: You lost $"+totalLosses);
   
    }

     


  
    in.close();
  }
  
  private static String checkCards(String playerHand, String dealerHand) {
    //players cards
    int spaceLocation1 = playerHand.indexOf(" ");
    String lastTwoCards = playerHand.substring(spaceLocation1+1, playerHand.length());
    int spaceLocation2 = lastTwoCards.indexOf(" ");
    String playerCard3 = lastTwoCards.substring(spaceLocation2+1, lastTwoCards.length());
    String playerCard2 = lastTwoCards.substring(0, spaceLocation2);
    String playerCard1 = playerHand.substring(0,spaceLocation1);
    System.out.println(playerCard1);
    System.out.println(playerCard2);
    System.out.println(playerCard3);
    int playerHandValue = checkHandValue(playerCard1, playerCard2, playerCard3);
    System.out.println("Player hand value" + playerHandValue);
    //dealer cards 
    int dealerSpaceLocation1 = dealerHand.indexOf(" ");
    String dealerLastTwoCards = dealerHand.substring(dealerSpaceLocation1+1, dealerHand.length());
    int dealerSpaceLocation2 = dealerLastTwoCards.indexOf(" ");
    String dealerCard3 = dealerLastTwoCards.substring(dealerSpaceLocation2+1, dealerLastTwoCards.length());
    String dealerCard2 = dealerLastTwoCards.substring(0, dealerSpaceLocation2);
    String dealerCard1 = dealerHand.substring(0,dealerSpaceLocation1);
    System.out.println(dealerCard1);
    System.out.println(dealerCard2);
    System.out.println(dealerCard3);
    int dealerHandValue = checkHandValue(dealerCard1, dealerCard2, dealerCard3);
    System.out.println("Dealer hand value" + dealerHandValue);
    if(dealerHandValue > playerHandValue){
      return "Dealer";
    } else if(dealerHandValue < playerHandValue){
      return "Player";
    } else if(dealerHandValue == playerHandValue){
      int playerCard1Face = getFace(playerCard1);
    int playerCard2Face = getFace(playerCard2);
    int playerCard3Face = getFace(playerCard3);
    int playerCardTotal = playerCard1Face+playerCard2Face+playerCard3Face;
    
    int dealerCard1Face = getFace(dealerCard1);
    int dealerCard2Face = getFace(dealerCard2);
    int dealerCard3Face = getFace(dealerCard3);
    int dealerCardTotal = dealerCard1Face+dealerCard2Face+dealerCard3Face;
    if(playerCardTotal > dealerCardTotal){
      return "Player";
    } else if(playerCardTotal < dealerCardTotal) {
      return "Dealer";
    } else {
      return "Tie";
    }

    } else {
      return null;
    }
  }

  private static int checkHandValue(String card1, String card2, String card3) {
    int card1Face = getFace(card1);
    String card1Suit = getSuit(card1);
    int card2Face = getFace(card2);
    String card2Suit = getSuit(card2);
    int card3Face = getFace(card3);
    String card3Suit = getSuit(card3);
    if(card1Suit.equals(card2Suit) && card2Suit.equals(card3Suit) && card1Face-card2Face == 1 && card2Face-card3Face == 1){
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
    if(dealerHand.indexOf('Q') > 0 || dealerHand.indexOf('K') > 0 || dealerHand.indexOf('A') > 0){
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
    return getFace() + getSuit();
  }

  private static String getSuit() {
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

  private static String getFace() {
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
