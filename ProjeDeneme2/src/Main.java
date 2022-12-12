public class Main {
    public static void main(String[] args) {

        CreateDeckCards CardCreator = new CreateDeckCards();

        String[] card52InOrder = CardCreator.create52CardInOrder();     // Created 52 card in order
        String[] mixed52Card = CardCreator.shuttleCards(card52InOrder); // send 52 which are in order to the mixer

        // when the game start !!!
        String[] distributeCards40 =  CardCreator.distributeCards();
        String[] Player4Card =  CardCreator.getPlayer4Card();
        String[] Computer4Card =  CardCreator.getComputer4Card();
        String[] Middle4Card =  CardCreator.getMiddle4Card();

        GameMechanics Mechanics = new GameMechanics(distributeCards40,Player4Card,Computer4Card,Middle4Card);

        Mechanics.control();
    }
}
