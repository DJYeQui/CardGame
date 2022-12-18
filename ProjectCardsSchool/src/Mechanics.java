import java.util.Scanner;

public class Mechanics {
    private int preparationGameCardsDistribute = 0;
    private String[] mixed48Card = new String[48];
    private String[] middleCollectedCard = new String[52];
    private String[] player4Card = new String[4];
    private String[] computer4Card = new String[4];

    public Mechanics(String[] mixedCardDeck52){

        //  4 cards added to middle
        System.arraycopy(mixedCardDeck52,0,middleCollectedCard,0,4);
        System.err.println(middleCollectedCard[3] + " last middle card");
        // other 48 card sent to the mixed48Card for use in other method
        System.arraycopy(mixedCardDeck52,4,mixed48Card,0,mixed48Card.length);
    }

    public void preparationGame(){
        // preparationGameCardsDistribute:  is a counter for these 2 loop till 48
        // player4Card elements added
        for (int cardIndexPlayer = 0; cardIndexPlayer < 4; cardIndexPlayer++) {
            player4Card[cardIndexPlayer] = mixed48Card[preparationGameCardsDistribute] + " = " + cardIndexPlayer + "th";   // 3,11,19,27,35,43
            preparationGameCardsDistribute++;    // last element indexes values: 4,12,20,28,36,44
        }

        // computer4Card elements added
        for (int cardIndexPlayer = 0; cardIndexPlayer < 4; cardIndexPlayer++) {  //  7,15,23,31,39,47
            computer4Card[cardIndexPlayer] = mixed48Card[preparationGameCardsDistribute];
            preparationGameCardsDistribute++;    // last elements indexes values: 8,16,24,32,40,48
        }
    }

    public void playCards(){
        // there are 4 card to each player (user and computer)
        for (int index = 0; index < 4; index++){

            //Show the cards to player
            for (int showCards = 0; showCards<4; showCards++){
                System.out.println(player4Card[showCards]);
            }

            int selectedIndex = playerSelectedIndexCardControl();
            int lastElementIndexOfMiddleCollectedCard= findTheLastElementOfMiddleCollectedCard();


        }
    }


    // these are using for creating easier way
    public int playerSelectedIndexCardControl(){
        Scanner sc = new Scanner(System.in);

        System.out.println("pls enter the cards order number");
        int selectedIndex = sc.nextInt();
        if (selectedIndex>=0 && selectedIndex<4){
            for (int i = 0; i<4 ; i++){
                if (player4Card[i]!=null){

                    String player4CardElement = player4Card[i];
                    char cardOrder = player4CardElement.charAt(5);
                    int cardOrderCharToInt = Character.getNumericValue(cardOrder);

                    if (cardOrderCharToInt==selectedIndex){
                        System.out.println(cardOrderCharToInt + " its here");
                        return selectedIndex;
                    }
                }
            }
        }
        else {
            return playerSelectedIndexCardControl();
        }
        return playerSelectedIndexCardControl();
    }

    public int findTheLastElementOfMiddleCollectedCard(){
        int lastElementIndex = 0;
        for (int index = 51; index>0; index--){
            if (middleCollectedCard[index]!= null){
                lastElementIndex = index;
                break;
            }
        }
        
        return lastElementIndex;
    }
}
