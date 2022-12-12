import java.util.Random;

public class CreateDeckCards {
    private String[] cardNumbers = {" 2 "," 3 "," 4 "," 5 "," 6 "," 7 "," 8 "," 9 "," 10 "," A (Ace) "," J (Jack)"," Q (Queen)"," K (King)"};
    private String[] cardShapes = {"♠" , "♣" , "♥" , "♦"};
    private String[] card52InOrder = new String[52];
    private String[] middleCardWhichPlayed = new String[52];
    private String[] player4Card = new String[4];
    private String[] computer4Card = new String[4];

    public String[] create52CardInOrder(){
        int counter = 0;

        for (int i =0; i<4;i++){
            for (int j = 0; j<13;j++){
                card52InOrder[counter] = cardShapes[i]+cardNumbers[j];
                counter++;
            }
        }
        return card52InOrder;
    }

    public String[] shuttleCards(String[] card52){
        Random random = new Random(System.currentTimeMillis());
        String placeHolder;

        for (int i =0; i<52; i++){
            placeHolder = card52[i];
            int randomIndex = random.nextInt(0,52);
            card52[i]=card52[randomIndex];
            card52[randomIndex] = placeHolder;
        }
        return card52;
    }
    public String[] distributeCards(String[] mixedCards){
        int counterForDistributeCards =0;

        for (int i =0; i<4;i++){       // adding4 card o middle
            middleCardWhichPlayed[i] = mixedCards[counterForDistributeCards];
            counterForDistributeCards++;
            System.out.println(middleCardWhichPlayed[i]);
        }
        System.out.println("-------------------------------------------------");

        for (int i =0; i<4;i++){      // adding4 card o playerCards
            player4Card[i] = mixedCards[counterForDistributeCards];
            counterForDistributeCards++;
            System.out.println(player4Card[i]);
        }
        System.out.println("-------------------------------------------------");
        for (int i =0; i<4;i++){      // adding4 card o computerCards
            computer4Card[i] = mixedCards[counterForDistributeCards];
            counterForDistributeCards++;
            System.out.println(computer4Card[i]);
        }
        System.out.println("-------------------------------------------------");
        String[] cardDeckAfterCardsDistributed = new String[40];
        for (int i =0; i<40;i++){
            cardDeckAfterCardsDistributed[i] = mixedCards[i+12];
        }
        return cardDeckAfterCardsDistributed;   //the card deck, after distribute 12 card
    }
}
