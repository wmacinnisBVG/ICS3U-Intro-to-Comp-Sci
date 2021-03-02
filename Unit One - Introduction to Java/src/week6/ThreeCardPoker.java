package week6;

public class ThreeCardPoker {

    private static final int NUM_FACES = 13;
    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    private static final int ACE = 14;
    String playerhand = "";
    public static void main(String[] args) {
      // String card = getCard(); 
      System.out.println(getSuit());
    }

    private static String getCard() {
        return getFace() * getSuit();
    }

    private static String getSuit() {
        int rand = (int)(Math.random() * 4) + 1;
        if(rand == 1){
            return "H";
        } else if(rand == 2){
            return "S";
        } else if(rand == 3){
            return "D";
        } else if(rand == 4){
            return "C";
        } else {
            return "error";
        }
    }

    private static String getFace() {
        int face = (int)(Math.random() * NUM_FACES) + 2;
        if(face >= 2 && face <= 10){
            return ""+face;
        } else if(face == JACK){
            return "J";
        } else if(face == QUEEN){
            return "Q";
        } else if(face == KING){
            return "K";
        } else if(face == ACE) {
            return "A";
        } else {
            return null;
        }
        public static boolean isUnique(String playerHand, String card) {	
            return playerHand.indexOf(card) == -1;
    }
    for (int i = 0; i < 3; i++) {
        Boolean hasCard= false;
        while(!hasCard){
            String card = getCard();
            if (isUnique(playerHand, card)){
                playerHand += card + " ";
                hasCard= true;
            }
        }
}
    }

}
