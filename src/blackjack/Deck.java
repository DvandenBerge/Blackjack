 package blackjack;
import java.util.Random;

public class Deck {
    private static Random rng = new Random();
    private Card[] cardDeck=new Card[52];
    
    //Creates 52 cards using the 2-int Card constructor
    public Deck(){
        int count=0;
        
        for(int i=0;i<4;i++){ //Passes i and j from for loops into the Card constructor
            for(int j=1;j<14;j++){
                cardDeck[count]=new Card(i,j); //finally, the card is added to the cardDeck array
                count++;
            }
        }
    }
    
    //Implementing a Fisher-Yates shuffle
    public void shuffleDeck(){
        for(int a=cardDeck.length-1;a>=1;a--){
            int rand=rng.nextInt(a);    //create a random index number between 0 and integer a
            Card temp=cardDeck[rand];   //a temporary Card object holds the Card info of ( cardDeck[rand] ) 
            cardDeck[rand]=cardDeck[a]; //the Card specified by the for loop (a) is put in the place of ( cardDeck[rand] )
            cardDeck[a]=temp;           //the temp card is placed in the for loop (a) index ( cardDeck[a] ) 
        }
    }
    
    public Card getCard(int j){
        return cardDeck[j];
    }
}
