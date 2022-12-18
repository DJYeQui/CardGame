public class Main {
    public static void main(String[] args) {
        Cards Card = new Cards();
        String[] mixedCards = Card.mix52Cards();
        Mechanics Game = new Mechanics(mixedCards);

        Game.preparationGame();
        Game.playCards();
        
    }
}
