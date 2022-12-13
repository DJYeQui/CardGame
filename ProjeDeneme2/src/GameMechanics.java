import java.util.Random;
import java.util.Scanner;

public class GameMechanics {
    CreateDeckCards GameCards = new CreateDeckCards();

    public int counterWhileLoop = 0;
    public String[] cardCollectMiddle= new String[52];
    public String[] distributeCards40;
    public String[] player4Card;
    public String[] computer4Card;
    public String[] middle4Card;
    public GameMechanics(String[] distributeCards1 , String[] Player4Card1 , String[] Computer4Card1 , String[] Middle4Card1){

          distributeCards40 =  distributeCards1;
        player4Card =  Player4Card1;
        computer4Card =  Computer4Card1;
        middle4Card =  Middle4Card1;

        for(int i = 0; i<4; i++){       // add the 4 card to the cardCollectMiddle Array
            cardCollectMiddle[i]=middle4Card[i];
        }
    }

    public void control(){
        for (int i =0; i<4;i++){
            System.out.println(player4Card[i]);
            System.out.println(middle4Card[i]);
            System.out.println(computer4Card[i]);

        }
        for (int i = 0; i<40;i++){
            System.out.println(distributeCards40[i]);
        }
    }

    public String[] playerPlayCardsFirst4Card(){
        Scanner sc = new Scanner(System.in);
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i<4;i++){

            // Show the player card
            for (int j = 0; j <4; j++){
                if (player4Card[j]!=null){
                    System.out.println(player4Card[j]+" = "+ j+ "th Card");
                }
            }
            System.out.println("pls enter a value which is next to the cards");
            System.out.println("---------------------------------------------");
            int indexPlayerCard = sc.nextInt(); // take value for play a card

            //transport the values to cardCollectMiddle
            cardCollectMiddle[2*i+4] = player4Card[indexPlayerCard];
            player4Card[indexPlayerCard]=null;  // instead  of delete

            cardCollectMiddle[2*i+5] = computer4Card[i];
            computer4Card[i]=null;

            //show the computer cards
            for (int j = 0; j <4; j++){
                if (computer4Card[j]!=null){
                    System.out.println(computer4Card[j]+" = "+ j+ "th Card");
                }
            }
            System.out.println("---------------------------------------------");

            // Show the cardCollectMiddle
            System.out.println("----------------Middle Card-----------------");
            for (int j = 0; j <cardCollectMiddle.length; j++){
                if (cardCollectMiddle[j]!=null){
                    System.out.println(cardCollectMiddle[j]);
                }
            }
            System.out.println("---------------------------------------------");
        }
        return cardCollectMiddle;
    }
}
