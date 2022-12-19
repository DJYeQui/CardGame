public class Main {
    public static void main(String[] args) {
        Cards Card = new Cards();
        String[] mixedCards = Card.mix52Cards();
        Mechanics Game = new Mechanics(mixedCards);
        

        for (int index = 0; index <6; index++){
            Game.preparationGame();
            Game.playCards();}

        int playerScore = Game.getPlayScore();
        int computerScore = Game.getPlayScore();
        ScoreList scoreList = new ScoreList(playerScore,computerScore);

    }
}
