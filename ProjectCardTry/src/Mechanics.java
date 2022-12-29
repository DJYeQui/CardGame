import java.util.Scanner;

public class Mechanics {
    private int playerScore = 0;
    private int computerScore = 0;
    private int preparationGameCardsDistribute = 0;
    private String whoWinLast = "";  // P means player = C means computer
    private String[] mixed48Card = new String[48];
    private String[] middleCollectedCard = new String[52];
    private String[] player4Card = new String[4];
    private String[] computer4Card = new String[4];

    public Mechanics(String[] mixedCardDeck52) {

        //  4 cards added to middle
        for (int index = 0; index < 4; index++) {
            middleCollectedCard[index] = mixedCardDeck52[index] + " = " + index + "th";
        }

        // other 48 card sent to the mixed48Card for use in other method
        System.arraycopy(mixedCardDeck52, 4, mixed48Card, 0, mixed48Card.length);   //48 card stored for distribution in to the preparationGame
    }

    public void preparationGame() {
        // preparationGameCardsDistribute:  is a counter for these 2 loop till 48
        // player4Card elements added
        for (int cardIndexPlayer = 0; cardIndexPlayer < 4; cardIndexPlayer++) {
            player4Card[cardIndexPlayer] = mixed48Card[preparationGameCardsDistribute] + " = " + cardIndexPlayer + "th";   // 3,11,19,27,35,43
            preparationGameCardsDistribute++;    // last element indexes values: 4,12,20,28,36,44


        }

        // computer4Card elements added
        for (int cardIndexPlayer = 0; cardIndexPlayer < 4; cardIndexPlayer++) {
            computer4Card[cardIndexPlayer] = mixed48Card[preparationGameCardsDistribute] + " = " + cardIndexPlayer + "th"; //  7,15,23,31,39,47
            preparationGameCardsDistribute++;    // last elements indexes values: 8,16,24,32,40,48
        }
    }


    /**
     * step by step what will I do
     * "♠10 = 2th" card assignment format
     * for 4 times play this
     *         //show the middle cards
     *         //show the players cards
     *         //take input from player
     *         //control the input
     *         //control is there card in player card
     *         //find the last element of middleCollectedCard
     *         //send the card to the middleCollectedCard
     *         //card[i]=null
     *         //check the points
     *         //computer play card
     *         //computer[i]=null
     *         //check point
     */
    public void playCards() {


        //=====================================Player Process====================================//
        for (int index = 0; index < 4; index++) {

            //show the middle cards
            System.out.println("-----------middle cards-----------");
            for (int i = 51; i >= 0; i--) {
                if (middleCollectedCard[i] != null) {
                    System.out.println(middleCollectedCard[i].substring(0, 3));
                    break;
                }
            }

            //show the players cards
            System.out.println("-----------player cards-----------");
            for (int i = 0; i < 4; i++) {
                if (player4Card[i] != null) {
                    System.out.println(player4Card[i]);
                }
            }

            /*** take input from player
             * control the input*/
            int playerInput = controlCard();

            /*** find the last element of middleCollectedCard
             * this method find the first null element index in array/ I can use directly for declare something*/
            int lastElementOfMiddleCollectedCardArray = lastElementMiddleCollectedCard();

            /*** send the card to the middleCollectedCard
             * card[i]=null*/
            middleCollectedCard[lastElementOfMiddleCollectedCardArray] = player4Card[playerInput];
            player4Card[playerInput] = null;

            //check the points player
            if (lastElementMiddleCollectedCard() >= 2) {
                pointCounterPlayer();
            }

            /*** ================================Computer Process=============================//
             * Write AI for decide the card index as a computer
             * send the card to the middleCollectedCard
             * computer[i]=null*/
            computerPlayCard();

            /***check the points computer
             * for prevent the null error if added*/
            if (lastElementMiddleCollectedCard() >= 2) {
                pointCounterComputer();
            }
        }
    }

    public void computerPlayCard() {
        int lastElementMiddleCollectedCardAfterPlayer = lastElementMiddleCollectedCard();
        boolean controlWhichOneExecute = false;

        // if player gain point middleCollectCard become empty and that create problem
        if (lastElementMiddleCollectedCardAfterPlayer >= 1) {
            for (int i = 0; i < 4; i++) {
                if (computer4Card[i] != null) {
                    if (computer4Card[i].substring(1, 3).equals(middleCollectedCard[lastElementMiddleCollectedCardAfterPlayer - 1].substring(1, 3)) || computer4Card[i].substring(1, 3).equals("J ")) {
                        middleCollectedCard[lastElementMiddleCollectedCardAfterPlayer] = computer4Card[i];
                        computer4Card[i] = null;
                        controlWhichOneExecute = true;
                        break;
                    }
                }
            }
        }

        if (controlWhichOneExecute == false) {
            for (int i = 0; i < 4; i++) {
                if (computer4Card[i] != null) {
                    middleCollectedCard[lastElementMiddleCollectedCardAfterPlayer] = computer4Card[i];
                    computer4Card[i] = null;
                    break;
                }
            }
        }
    }

    public void pointCounterComputer() {
        int lastElementIndex = lastElementMiddleCollectedCard();
        if (lastElementIndex == 2 && middleCollectedCard[lastElementIndex - 1].substring(1, 3).equals(middleCollectedCard[lastElementIndex - 2].substring(1, 3))) {

            computerScore += 10;
            for (int i = 0; middleCollectedCard[i] != null; i++) {
                int point = cardValueList(middleCollectedCard[i]);
                computerScore = computerScore + point;
                middleCollectedCard[i] = null;
            }
            whoWinLast = "C";
            System.err.println("PISTI computer point: " + computerScore);

        }else if(middleCollectedCard[lastElementIndex - 1].substring(1,3).equals("J ") && middleCollectedCard[lastElementIndex - 1].length()==8){
            for (int i = 0; middleCollectedCard[i] != null; i++) {
                int point = cardValueList(middleCollectedCard[i]);
                computerScore = computerScore + point;
                middleCollectedCard[i] = null;
            }
            whoWinLast = "C";
            System.err.println("computer point: " + computerScore);
        }
        else {
            if (middleCollectedCard[lastElementIndex - 1].substring(1, 3).equals(middleCollectedCard[lastElementIndex - 2].substring(1, 3))) {

                for (int i = 0; middleCollectedCard[i] != null; i++) {
                    int point = cardValueList(middleCollectedCard[i]);
                    computerScore = computerScore + point;
                    middleCollectedCard[i] = null;
                }

                whoWinLast = "C";
                System.err.println("computer point: " + computerScore);
            }
        }

    }

    //check the points
    public void pointCounterPlayer() {
        int lastElementIndex = lastElementMiddleCollectedCard();
        if (lastElementIndex == 2 && middleCollectedCard[lastElementIndex - 1].substring(1, 3).equals(middleCollectedCard[lastElementIndex - 2].substring(1, 3))) {

            playerScore += 10;
            for (int i = 0; middleCollectedCard[i] != null; i++) {
                int point = cardValueList(middleCollectedCard[i]);
                playerScore = playerScore + point;
                middleCollectedCard[i] = null;
            }
            whoWinLast = "P";
            System.err.println("player point: " + playerScore);

        }else if(middleCollectedCard[lastElementIndex - 1].substring(1,3).equals("J ") && middleCollectedCard[lastElementIndex - 1].length()==8){
            for (int i = 0; middleCollectedCard[i] != null; i++) {
                int point = cardValueList(middleCollectedCard[i]);
                playerScore = playerScore + point;
                middleCollectedCard[i] = null;
            }
            whoWinLast = "P";
            System.err.println("player point: " + playerScore);
        }
        else {
            if (middleCollectedCard[lastElementIndex - 1].substring(1, 3).equals(middleCollectedCard[lastElementIndex - 2].substring(1, 3))) {

                for (int i = 0; middleCollectedCard[i] != null; i++) {
                    int point = cardValueList(middleCollectedCard[i]);
                    playerScore = playerScore + point;
                    middleCollectedCard[i] = null;
                }
                whoWinLast = "P";
                System.err.println("player point: " + playerScore);
            }
        }
    }

    public int cardValueList(String gainedCard) {
        if (gainedCard.substring(0, 3).equals("♦10")) {
            return 3;
        } else if (gainedCard.substring(0, 2).equals("♣2")) {
            return 2;
        } else {
            return 1;
        }
    }

    public int controlCard() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pls enter cards order number which is written next to the card");
        int takenInput=0;

        //input type and interval control
        try {
            while (true){
                takenInput = sc.nextInt();
                if (takenInput >= 4 || takenInput < 0) {
                    System.out.println("input have to be in [0,4) interval");
                }else{break;}
            }

        } catch (Exception e) {
            System.out.println("this input can not use");
            return controlCard();
        }

        // is there a card in player cards
        if (isThereCardSelected(takenInput) == true) {
            return takenInput;
        } else {
            return controlCard();
        }
    }

    public boolean isThereCardSelected(int controlledIndex) {
        //control is there card in player cards
        try {

            int lengthOfElementSelected = player4Card[controlledIndex].length();
            char selectedCard = player4Card[controlledIndex].charAt(lengthOfElementSelected - 3);
            int numSelected = Character.valueOf(selectedCard);

            // if ith element is null that create a problem so I used try catch for solve it
            for (int i = 0; i < 4; i++) {
                try {
                    int lengthOfElement = player4Card[i].length();
                    char cardsLast3 = player4Card[i].charAt(lengthOfElement - 3);

                    int num1 = Character.valueOf(cardsLast3);

                    if (num1 == numSelected) {
                        return true;
                    }
                } catch (Exception e) {
                    continue;
                }

            }
        } catch (Exception e) {
            System.out.println("there is a problem try again");
        }
        return false;
    }

    public int lastElementMiddleCollectedCard() {
        int counter = 0;
        for (int i = 0; middleCollectedCard[i] != null; i++) {
            counter++;
        }
        return counter;
    }

    public void lastCardsCollectedByWinner(){
        if(whoWinLast.equals("P")){
            for (int i = 0; middleCollectedCard[i] != null; i++) {
                int point = cardValueList(middleCollectedCard[i]);
                playerScore = playerScore + point;
                middleCollectedCard[i] = null;
            }
            // that will delete
            System.out.println("Last Elements sent to player score");
        }
        else if (whoWinLast.equals("C")){
            for (int i = 0; middleCollectedCard[i] != null; i++) {
                int point = cardValueList(middleCollectedCard[i]);
                computerScore = computerScore + point;
                middleCollectedCard[i] = null;
            }
            // that will delete
            System.out.println("cards which are in the middle sent to computer score");
        }
        else {
            System.out.println("no one gain the points so cards stay in middle");
        }
    }

    public int getPlayScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }
}
