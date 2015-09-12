package blackjack;

public class Card {
    private String suit;
    private String face;
    private int value;
    
    //Constructor to make a card based on 2 integer values
    public Card(int suit, int value){
        switch(suit){
            case 0: this.suit="Spades";
                break;
            case 1: this.suit="Clubs";
                break;
            case 2: this.suit="Hearts";
                break;
            case 3: this.suit="Diamonds";
                break;
        }
        switch(value){
            case 1:  this.face="Ace";
                     this.value=1;
                     break;
            case 11: this.face="Jack";
                     this.value=10;
                     break;
            case 12: this.face="Queen";
                     this.value=10;
                     break;
            case 13: this.face="King";
                     this.value=10;
                     break;
            default: this.value=value;
                     this.face=Integer.toString(value);
                
        }
    }
    
    @Override
    public String toString(){
        return this.face+" of "+this.suit;
    }
    public int getValue(){
        return this.value;
    }
    public String getFace(){
        return this.face;
    }
}
