import java.io.IOException;
import java.util.Scanner;
import java.util.Formatter;
import java.io.FileWriter;
import java.nio.file.Paths;

/* In the people.txt it has to be 20 zero like that
0 0
0 0
0 0
0 0
0 0
0 0
0 0
0 0
0 0
0 0
*/
public class ScoreList {
    private int playerScore;

    public ScoreList(int pScore) {
        playerScore = pScore;
    }

    public void scoreList() {

        // copy  old list values from txt file
        String[][] listPlayerNamePoint = new String[11][2];

        System.out.println("pls enter score");
        String playerName = name(); // there was a problem to take name

        listPlayerNamePoint[10][0] = playerName;
        listPlayerNamePoint[10][1] = Integer.toString(playerScore);

        Scanner reader = null;
        try {
            reader = new Scanner(Paths.get("people.txt"));


            int counterExecution = 0;

            while (reader.hasNextLine()) {
                String[] oldListValues = reader.nextLine().split("  ");
                if (counterExecution <= 10) {
                    for (int index = 0; index < 2; index++) {
                        if (listPlayerNamePoint[counterExecution][0] == null && listPlayerNamePoint[counterExecution][1] == null) {
                            listPlayerNamePoint[counterExecution][0] = Integer.toString(0);
                            listPlayerNamePoint[counterExecution][1] = Integer.toString(0);
                        }
                        listPlayerNamePoint[counterExecution][index] = oldListValues[index];
                    }
                }
                counterExecution++;
            }
        } catch (IOException e) {
            e.printStackTrace();    // for see error's detail
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (listPlayerNamePoint[i][1] != null && listPlayerNamePoint[j][1] != null) {

                    int a = Integer.parseInt(listPlayerNamePoint[i][1]);
                    int b = Integer.parseInt(listPlayerNamePoint[j][1]);

                    String a2 = listPlayerNamePoint[i][0];
                    String b2 = listPlayerNamePoint[j][0];

                    if (a > b) {
                        String placeHolder = Integer.toString(a);
                        String placeHolder2 = a2;

                        listPlayerNamePoint[i][1] = listPlayerNamePoint[j][1];
                        listPlayerNamePoint[j][1] = placeHolder;

                        listPlayerNamePoint[i][0] = listPlayerNamePoint[j][0];
                        listPlayerNamePoint[j][0] = placeHolder2;
                    }
                }
            }
        }

        // control the all print
        System.out.println("================ Score List =================");
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(listPlayerNamePoint[i][j]);

            }
        }
        printTxt(listPlayerNamePoint);
    }

    public static void printTxt(String[][] listInOrder) {

        Formatter f = null;
        Formatter deleteAllText = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter("people.txt", true);
            f = new Formatter(fw);
            deleteAllText = new Formatter("people.txt");

            deleteAllText.format(" ");

            for (int i = 0; i < 10; i++) {
                if (listInOrder[i][0]==null || listInOrder[i][1]==null){
                    String zero = "0";
                    listInOrder[i][0]=zero;
                    listInOrder[i][1]=zero;
                }
                f.format("%s  %s\n", listInOrder[i][0], listInOrder[i][1]);
            }

            fw.close();
        } catch (Exception e) {
            System.err.println("Something went wrong.");
        } finally {
            if (f != null) {
                f.close();
            }
        }
    }

    public static String name() {
        Scanner sc = new Scanner(System.in);
        System.out.println("YOU WINN CONG. pls enter your first name");
        String name = sc.nextLine();
        String[] playerComplexName = name.split("  ");
        return playerComplexName[0];
    }
}
