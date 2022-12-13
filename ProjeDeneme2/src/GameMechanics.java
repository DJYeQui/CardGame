import java.util.Random;
import java.util.Scanner;

public class GameMechanics {
    CreateDeckCards GameCards = new CreateDeckCards();
    public int pointPistiPlayer = 0;
    public int pointPistiComputer = 0;

    public String[] pointCounterPlayerArray = new String[52];
    public String[] pointCounterComputerArray = new String[52];


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

            System.out.println("---------------------------------------------");
            System.out.println("pls enter a value which is next to the cards");
            int indexPlayerCard = sc.nextInt(); // take value for play a card

            //transport the values to cardCollectMiddle
            cardCollectMiddle[2*i+4] = player4Card[indexPlayerCard];
            player4Card[indexPlayerCard]=null;  // instead  of delete
            pointCounterPlayer(2*i+4);

            cardCollectMiddle[2*i+5] = computer4Card[i];
            computer4Card[i]=null;

            // Show the cardCollectMiddle
            System.out.println("----------------Middle Card-----------------");
            for (int j = 0; j <cardCollectMiddle.length; j++){
                if (cardCollectMiddle[j]!=null){
                    System.out.println(cardCollectMiddle[j]);
                }
            }
            System.out.println("---------------------------------------------");

//            //show the computer cards
//            for (int j = 0; j <4; j++){
//                if (computer4Card[j]!=null){
//                    System.out.println(computer4Card[j]);
//                }
//            }
//            System.out.println("---------------------------------------------");

            pointCounterPlayer(2*i+5);
        }
        return cardCollectMiddle;
    }
    public void pointCounterPlayer(int indexElement1){
        char num1= '1';
        char num2= '2';

        if (cardCollectMiddle[indexElement1]!=null){
            char a =cardCollectMiddle[indexElement1].charAt(2);
            num1=a;
        }
        if (cardCollectMiddle[indexElement1-1]!=null){
            char b =cardCollectMiddle[indexElement1-1].charAt(2);
            num2=b;
        }

        if (num1==num2){
            if (indexElement1%2==0){
                System.out.println("Cards are COLLECTED by PLAYER");
                int counter = 0;
                for (int i = 0; i<52; i++){
                    if (cardCollectMiddle!=null){counter++;}
                    if (counter==2){
                        pointPistiPlayer = pointPistiComputer + 10;
                    }
                }

                for (int i = 0; i<52; i++){
                    pointCounterPlayerArray[i]=cardCollectMiddle[i];
                    cardCollectMiddle[i]=null;
                }
            }
            else {
                System.out.println("Cards are COLLECTED by COMPUTER");
                int counter = 0;
                for (int i = 0; i<52; i++){
                    if (cardCollectMiddle!=null){counter++;}
                    if (counter==2){
                        pointPistiComputer = pointPistiComputer + 10;
                    }
                }

                for (int i = 0; i<52; i++){
                    pointCounterComputerArray[i]=cardCollectMiddle[i];
                    cardCollectMiddle[i]=null;
                }
            }
        }
    }
}
