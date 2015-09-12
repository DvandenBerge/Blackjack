package blackjack;

public class Dealer extends Player {
     private Deck dealerDeck= new Deck();
     private int currentCard=0;
     
     public Dealer(){
         super();
         dealerDeck.shuffleDeck();
         dealerDeck.shuffleDeck();
     }
     
     public void dealCards(Player[] people){
         for(int j=0;j<2;j++){
            for(Player pl:people){
                pl.getHand().add(dealerDeck.getCard(currentCard++));
                checkDeck();
            }
         }
     }
     
     private void checkDeck(){
         if(currentCard==52){
             dealerDeck.shuffleDeck();
             currentCard=0;
         }
     }
     
     public void showCards(boolean isTurn){
         if(!isTurn){
             System.out.println("Dealer is showing a "+this.getHand().get(0));
         }else{
             this.showHand();
         }
     }
     
     public void hit(Player pl){
         pl.receiveCard(dealerDeck.getCard(currentCard++));
         checkDeck();
     }
     
     //Dealer draws cards until 17 or more
     public void completeHand(){
         while(this.getHandValue()<17){
             hit(this);
         }
         this.showHand();
     }
}
