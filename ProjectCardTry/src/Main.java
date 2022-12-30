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

        //data which created after game process
        int playerScore = Game.getPlayScore();
        int computerScore = Game.getComputerScore();
        ScoreList scoreList = new ScoreList(playerScore);

        // PC PLAYER POINTS
        System.out.println("player score: "+playerScore);
        System.out.println("computer score: "+computerScore);

        if(playerScore>computerScore){System.err.println("winner player");
            //score list
            scoreList.scoreList();
        }
        else if(playerScore<computerScore){System.err.println("winner computer");}
        else {System.err.println("there is no winner");}
    }
}
