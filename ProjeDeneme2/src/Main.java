public class Main {
    public static void main(String[] args) {

        CreateDeckCards CardCreator = new CreateDeckCards();

        String[] card52InOrder = CardCreator.create52CardInOrder();     // Created 52 card in order
        String[] mixed52Card = CardCreator.shuttleCards(card52InOrder); // send 52 which are in order to the mixer
        String[] card40AfterDistribution = CardCreator.distributeCards(mixed52Card);

        CardCreator.distributeCards(mixed52Card);

        for (int i =0; i<40;i++){
            System.out.println(card40AfterDistribution[i]);
        }

    }
}