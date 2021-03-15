package week8;
public class GameCube{
    int topSide;
    int numSides; 
    GameCube(int numberOfSides){
        numSides = numberOfSides;
        roll();
    }
    GameCube(){
        numSides = 6;
        roll(); 
    }
    void roll(){
        topSide = (int) (Math.random()*numSides+1); 

    }
    int getTopSide;
    int getTopSide(){
        return topSide;
    }

}