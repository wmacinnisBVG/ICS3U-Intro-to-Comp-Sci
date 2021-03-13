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

    //Asks player for an ante wager
    System.out.print("(Ante wager) ");
    int anteWager = getWager(in);

    //checks if the player wants to wager a pair plus bet
    boolean pairPlusWagerCheck = checkPairPlusWager(in);

    //Dealing player and dealers hands 
    String playerHand = dealCards();
    String dealerHand = dealCards();
    int pairPlusWager = 0;
    
    //Checks if player wants to set a pair plus wager  
    if(pairPlusWagerCheck == true){
      System.out.print("(Pair plus wager) ");
      pairPlusWager = getWager(in);
      System.out.println("Your pair plus wager is: $"+pairPlusWager);
    } else {
      System.out.println("You did not bet on a pair plus wager.");
    }

    //Prints all wagers for player to see before asking if they want to play the game 
    System.out.println("Your ante wager is: $"+anteWager);
    System.out.println("Your play wager is: $"+anteWager);
    System.out.println("Your cards are: " + playerHand);

    //Checks if player wants to play the game 
    boolean play = playGame(in);

    //If the player does want to play the game continue 
    if(play == true){
        //Set play wager = to ante wager because they have to be the same 
        int playWager = anteWager; 
        System.out.println("");
        System.out.println("Your cards are: " + playerHand);
        System.out.println("Your ante wager is: $"+anteWager);
        System.out.println("Your pair plus wager is: $"+pairPlusWager);
        System.out.println("Your play wager is: $"+playWager);
        System.out.println("-----------");
        System.out.println("Dealers cards are: " + dealerHand);
        boolean dealersHandCheck = checkDealersHand(dealerHand);
        
        //Check if dealer's hand qualifies 
        if(dealersHandCheck == true){
        //If dealer qualifies check which hand between the player and the dealer is better
        String whichHandIsBetter = checkCards(playerHand, dealerHand);
        if(whichHandIsBetter.equals("Dealer")){
          //If the dealers hand is better than the players hand
          int totalLosses = 0; 
          System.out.println("Oh no! You lost, the dealers hand was better than yours.");
          if(pairPlusWagerCheck == true){
            int pairPlusValue = checkHandValue(playerHand);
            int pairPlusWinnings = pairPlusValue * pairPlusWager;
            System.out.println("Your pair plus winnings are: $"+ pairPlusWinnings);
            //Check if the player set a pair plus wager and calculate winnings 
            if(pairPlusWinnings == 0){
              totalLosses += pairPlusWager;
            } else {
              totalLosses -= pairPlusWinnings; 
            }
          }
          totalLosses += anteWager*2; 
          System.out.println("Your total losses are: $"+totalLosses);
        } else if(whichHandIsBetter.equals("Player")){
          //If the players hand is better than the dealers hand
          int totalWinnings = 0;
          System.out.println("Congratulations! Your hand was better than the dealers hand. ");
          //Check if the player set a pair plus wager and calculate winnings 
          if(pairPlusWagerCheck == true){
            int pairPlusValue = checkHandValue(playerHand);
            int pairPlusWinnings = pairPlusValue * pairPlusWager;
            System.out.println("Your pair plus winnings are: $"+ pairPlusWinnings);
            totalWinnings += pairPlusWinnings; 
          }
          totalWinnings += anteWager*2;
          System.out.println("Your total winnings are: $"+totalWinnings);
        } else if(whichHandIsBetter.equals("Tie")){
          //If there is a tie (push rule A) between the dealer and the players hand
          int totalLosses = 0; 
          //Check if the player set a pair plus wager and calculate winnings 
          if(pairPlusWagerCheck == true){
            int pairPlusValue = checkHandValue(playerHand);
            int pairPlusWinnings = pairPlusValue * pairPlusWager;
            System.out.println("Your pair plus winnings are: $"+ pairPlusWinnings);
          }
          System.out.println("There was a push (tie)! You still loose your ante wager $"+anteWager+" but you get your play wager returned. ");

        } else {
          //If whichHandIsBetter does not return Player, Dealer, or Tie print ERROR and exit program (this should never happen)
          System.out.println("ERROR");
          System.exit(0);
        }

        } else {
          //If dealer does not qualify (dealers needs queen high or better to qualify)
          int payout = playWager;
          System.out.println("Dealer did not qualify, your play wager has been returned, but you have lost your ante wager. ");
          System.out.println("Payout: $"+payout);
        }
    } else {
      //If the player does not want to play the game after seeing their cards print the total losses 
      int totalLosses = pairPlusWager+(anteWager*2);
      System.out.println("You folded: You lost $"+totalLosses);
    }

    in.close();
  }
  /**
   * checkCards compares the hands of the player and dealer to find which hand is better using the hand rules for three card poker
   * @param playerHand the players hand randomly generated by the program
   * @param dealerHand the dealers hand randomly generated by the program
   * @return either "Dealer", "Player", or "Tie" depending on the outcome of the calculation 
   */
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

/**
 * getHighCardValue is called if there is no clear winner between the dealers hand and the players hand (a high card needs to be calculated from a hand)
 * @param hand either the dealers hand or players hand
 * @return the face of the high card
 */
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

  /**
   * checkHandValue converts the randomly generated hand by the program into a numerical value depending on the value of the card 
   * @param hand the players hand or dealers hand
   * @return the numerical representation of a hand 
   */
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

  /**
   * getSuit gets the suit of a card
   * @param card an individual value taken from a hand
   * @return the suit of the individual card
   */
  private static String getSuit(String card) {
    return card.substring(card.length()-1);
  }

  /**
   * getFace converts the alphanumeric face of a card to a numeric value
   * @param card a card in a hand 
   * @return
   */
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

  /**
   * checkDealersHand checks the dealers hand to see if it qualifies 
   * @param dealerHand the cards in the dealers hand (whole hand [3 cards])
   * @return either true or false whether the dealer's hand qualifies for the game (must be a Queen high or better)
   */
  private static boolean checkDealersHand(String dealerHand) {
    if(dealerHand.indexOf('Q') >= 0 || dealerHand.indexOf('K') >= 0 || dealerHand.indexOf('A') >= 0){
        return true;
    } else {
      return false;
    }
 
  }

  /**
   * checkPairPlusWager asks the player if they want to set a pair plus wager
   * @param in scanner from keyboard 
   * @return true or false depending on if the player wants to set a pair plus wager
   */
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

  /**
   * playGame asks the player if they want to play a game of 3 card poker after their cards are revealed 
   * @param in scanner from keyboard 
   * @return either true or false depending if the player wants to play the game
   */
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

  /**
   * getWager asks the player for a wager and filters correct and incorrect responses 
   * @param in scanner from keyboard 
   * @return int of wager (50-100)
   */
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

  /**
   * dealCards deals the cards for the player and the dealer 
   * @return hand of cards 
   */
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

  /**
   * getCard generates a card using a random face and suit
   * @return card 
   */
  private static String getCard() {
    return generateFace() + generateSuit();
  }

  /**
   * generateSuit generates a random suit for a card
   * @return suit for card 
   */
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

  /**
   * generateFace generates a random face for a card
   * @return suit for a card 
   */
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

  /**
   * is unique makes sure there are no duplicate cards 
   * @param playerHand the current hand of the player
   * @param card new card generated 
   * @return true or false depending on check if the card is unique 
   */
  public static boolean isUnique(String playerHand, String card) {
    return playerHand.indexOf(card) == -1;
  }

}
