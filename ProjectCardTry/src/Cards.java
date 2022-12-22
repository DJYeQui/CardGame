import java.util.Random;

public class Cards {
    private String[] cardsValue = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};
    private String[] cardsShapes = {"♠", "♣", "♥", "♦"};


    public String[] card52() {
        String[] card52 = new String[52];
        String combineValueShape;
        int indexCounter = 0;

        for (String shape : cardsShapes) {
            for (String values : cardsValue) {
                combineValueShape = shape + values;
                card52[indexCounter] = combineValueShape;
                indexCounter++;
            }
        }

        return card52;
    }


    public String[] mix52Cards() {

        Random arr = new Random(System.currentTimeMillis());
        String[] deck52 = card52();
        String storedOldVale;

        for (int index = 0; index < 26; index++) {
            int randomNumber = arr.nextInt(52);
            storedOldVale = deck52[index];
            deck52[index] = deck52[randomNumber];
            deck52[randomNumber] = storedOldVale;
        }

        //cut the cards 
        int cuttingPosition = arr.nextInt(10,30);  //that random number 30 maks and 10 min that can customize
        String[] shuffle1 = new String[cuttingPosition];
        String[] shuffle2 = new String[52-cuttingPosition];
        System.arraycopy(deck52,0,shuffle1,0,cuttingPosition);
        System.arraycopy(deck52,cuttingPosition,shuffle2,0,52-cuttingPosition);
        System.arraycopy(shuffle2,0,deck52,0,52-cuttingPosition);
        System.arraycopy(shuffle1,0,deck52,(52-cuttingPosition),cuttingPosition);

        return deck52;
    }
}
