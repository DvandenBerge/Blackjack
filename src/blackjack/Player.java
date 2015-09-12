package blackjack;
import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    
    public Player(){
        hand=new ArrayList(1);
    }
    public void showHand(){
        for(Card c:hand){
            System.out.println(c.toString());
        }
    }
    public ArrayList<Card> getHand(){
        return this.hand;
    }
    
    public int getHandValue(){
        int total=0;
        int aces=0;
        for(Card c:hand){
            if(c.getFace().equals("Ace")){
                aces++;
            }else{
                total+=c.getValue();
            }
        }
        //evaluate the aces at the end to ensure no errors
        for(int i=0;i<aces;i++){
            //Ternary operations!
            total+=((total+11<=21)?11:1);
        }
        return total;
    }
    
    public void receiveCard(Card c){
        this.hand.add(c);
    }
    
}
