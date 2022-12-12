public class GameMechanics {
    CreateDeckCards GameCards = new CreateDeckCards();
    public String[] distributeCards40 =  new String[40];
    public String[] Player4Card =  new String[4];
    public String[] Computer4Card =  new String[4];
    public String[] Middle4Card =  new String[4];
    public GameMechanics(String[] distributeCards1 , String[] Player4Card1 , String[] Computer4Card1 , String[] Middle4Card1){
          distributeCards40 =  distributeCards1;
          Player4Card =  Player4Card1;
          Computer4Card =  Computer4Card1;
          Middle4Card =  Middle4Card1;
    }

    public void control(){
        for (int i =0; i<4;i++){
            System.out.println(Player4Card[i]);
            System.out.println(Middle4Card[i]);
            System.out.println(Computer4Card[i]);

        }
        for (int i = 0; i<40;i++){
            System.out.println(distributeCards40[i]);
        }
    }

}
