public class Main {
    public static void main(String[] args) {
        Cards Card = new Cards();
        String[] mixedCards = Card.mix52Cards();
        Mechanics Game = new Mechanics(mixedCards);

        // game process
        for (int index = 0; index < 6; index++) {
            Game.preparationGame(); //
            Game.playCards();}
        Game.lastCardsCollectedByWinner();

        //for score list
        int playerScore = Game.getPlayScore();
//        int computerScore = Game.getComputerScore();   / that will delete
        ScoreList scoreList = new ScoreList(playerScore);
        scoreList.scoreList();
    }
}
