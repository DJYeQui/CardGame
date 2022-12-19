import java.util.Scanner;

public class Mechanics {
    private int playerScoreCard = 0;
    private int computerScoreCard = 0;
    private int preparationGameCardsDistribute = 0;
    private String[] mixed48Card = new String[48];
    private String[] middleCollectedCard = new String[52];
    private String[] player4Card = new String[4];
    private String[] computer4Card = new String[4];
    String[] listIndex = {"0","1","2","3"};

    public Mechanics(String[] mixedCardDeck52){

        //  4 cards added to middle
        for (int index = 0; index <4; index++){
            middleCollectedCard[index] = mixedCardDeck52[index] + " = " + index+"th";
        }

        // other 48 card sent to the mixed48Card for use in other method
        System.arraycopy(mixedCardDeck52,4,mixed48Card,0,mixed48Card.length);   //48 card stored for distribution in to the preparationGame
    }

    public void preparationGame(){
        // preparationGameCardsDistribute:  is a counter for these 2 loop till 48
        // player4Card elements added
        for (int cardIndexPlayer = 0; cardIndexPlayer < 4; cardIndexPlayer++) {
            player4Card[cardIndexPlayer] = mixed48Card[preparationGameCardsDistribute]+ " = " + cardIndexPlayer+"th";   // 3,11,19,27,35,43
            preparationGameCardsDistribute++;    // last element indexes values: 4,12,20,28,36,44
        }

        // computer4Card elements added
        for (int cardIndexPlayer = 0; cardIndexPlayer < 4; cardIndexPlayer++) {  //  7,15,23,31,39,47
            computer4Card[cardIndexPlayer] = mixed48Card[preparationGameCardsDistribute]+ " = " + cardIndexPlayer+"th";
            preparationGameCardsDistribute++;    // last elements indexes values: 8,16,24,32,40,48
        }
    }



    public void playCards(){

        // ♠10 = 2th
        //for 4 times play this
            //show the middle cards
            //show the players cards
            //take input from player
            //control the input
            //control is there card in player card
            //find the last element of middleCollectedCard
            //send the card to the middleCollectedCard
            //card[i]=null
            //check the points
            //computer play card
            //computer[i]=null
            //check point
        //------------------------------------------------------------------------------------------------------------//

        for (int index = 0; index<4;index++){
            //show the middle cards
            System.out.println("-----------middle cards-----------");
            for (int i = 0; middleCollectedCard[i]!=null ;i++){
                System.out.println(middleCollectedCard[i].substring(0,3));
            }

            //show the players cards
            System.out.println("-----------player cards-----------");
            for (int i = 0; i<4 ;i++){
                if (player4Card[i]!=null){
                    System.out.println(player4Card[i]);
                }
            }

            //take input from player
            //control the input
            int playerInput = controlCard();

            //find the last element of middleCollectedCard
            //this method find the first null place in array/ I can use directly
            int lastElementOfMiddleCollectedCardArray = lastElementMiddleCollectedCard();

            //send the card to the middleCollectedCard
            //card[i]=null
            middleCollectedCard[lastElementOfMiddleCollectedCardArray]=player4Card[playerInput];
            player4Card[playerInput]=null;
        }

    }










    public int controlCard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Pls enter cards order number which is written next to the card");
        int takenInput;

        //input type and interval control
        try {
            takenInput = sc.nextInt();
            if (takenInput>=4 || takenInput<0){
                System.out.println("input have to be in [0,4) interval");
                controlCard();
            }
        }
        catch (Exception e){
            System.out.println("this input can not use");
            return controlCard();
        }

        // is there a card in player cards
        if (isThereCardSelected(takenInput)==true){
            return takenInput;
        }
        else {
            return controlCard();
        }
    }


    public boolean isThereCardSelected(int controlledIndex){
        //control is there card in player cards
        try {
            int lengthOfElementSelected=player4Card[controlledIndex].length();
            char selectedCard = player4Card[controlledIndex].charAt(lengthOfElementSelected-3);

            int numSelected = Character.valueOf(selectedCard);

            // if ith element is null that create a problem so I used try catch for solve it
            for (int i = 0; i<4; i++){
                try{
                    int lengthOfElement=player4Card[i].length();
                    char cardsLast3 = player4Card[i].charAt(lengthOfElement-3);

                    int num1 = Character.valueOf(cardsLast3);

                    if (num1==numSelected){
                        return true;
                    }
                }catch (Exception e){
                    continue;
                }

            }
        }catch (Exception e){
            System.out.println("there is a problem try again");
        }
        return false;
    }

    public int lastElementMiddleCollectedCard(){
        int counter = 0;
        for (int i = 0; middleCollectedCard[i]!=null;i++){
            counter++;
        }
        return counter;
    }
}
