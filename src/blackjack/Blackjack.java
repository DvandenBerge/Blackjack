package blackjack;
import java.util.Scanner;

public class Blackjack {
    
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.print("How many players are playing? ");
        int totalPlayers=in.nextInt();
        in.nextLine();
        System.out.println("");
        
        //inititalize the Players and Dealer
        Player[] players = new Player[totalPlayers+1];
        Dealer dealer = new Dealer();
        
        for(int i=0;i<players.length-1;i++){
            players[i]=new Player(); //creating Players
        }
        
        players[players.length-1]=dealer; //Assign dealer as last player
        dealer.dealCards(players); //deal 2 cards to each Player
        
        //Print out all players hands
        for(int i=0;i<players.length-1;i++){
            System.out.println("Player "+(i+1)+"s hand:");
            players[i].showHand();
            System.out.println("");
        }
        dealer.showCards(false); //dealer shows first card
       
        for(int i=0;i<players.length-1;i++){
            String move="";
            System.out.println("\nPlayer "+(i+1)+", you hand:");
            players[i].showHand();
            if(players[i].getHandValue()==21){
                System.out.println("Blackjack!");
                move="stand";
            }
            while(!move.equals("stand")){
                System.out.print("Do you want to HIT or STAND?: ");
                move=in.nextLine();
                move=move.toLowerCase();
                if(move.equals("hit")){
                    dealer.hit(players[i]);
                    players[i].showHand();
                    if(players[i].getHandValue()==21){
                        System.out.println("Blackjack!");
                        move="stand";
                    }
                    else if(players[i].getHandValue()>21){
                        System.out.println("Bust!");
                        move="stand";
                    }
                }
            }
        }
        
        System.out.println("\nDealer shows their other card: ");
        dealer.showCards(true);
        System.out.println("\nDealers final hand: ");
        dealer.completeHand();
        System.out.println("");
        if(dealer.getHandValue()>21) System.out.println("Dealer busts!\n");
        
        for(int p=0;p<players.length-1;p++){
            if((dealer.getHandValue()<=21 && dealer.getHandValue()>players[p].getHandValue() ) || players[p].getHandValue()>21 ){ System.out.println("Player "+(p+1)+" loses with a "+players[p].getHandValue());}
            else if(dealer.getHandValue()<21 && players[p].getHandValue()==dealer.getHandValue()){ System.out.println("Player "+(p+1)+": it's a push!");}
            else{System.out.println("Player "+(p+1)+" wins with a "+players[p].getHandValue());
            }
        }
    }
}
    


