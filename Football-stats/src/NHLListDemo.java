/**
 * Author @ Sachit Singh Chawla, B00865842
 * This is the demo class which checks if the nhl stats class works and also prints the stats of the players
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NHLListDemo{
    public static void main(String [] args) throws IOException{
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the text file: ");

        String filename = keyboard.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        //Tokenizer intializing
        StringTokenizer token;

        // Initialize the object
        NHLStats ns = new NHLStats();
        PlayerRecord playerRecord;

        String name , position, teamName;
        String gamesPlayedS, goalScoredS, assistsS,
         penaltyMinutesS, shotOnGoalS, gameWinningGoalsS;

        while (inputFile.hasNext()){
            //takes token input from the input file and converts to integer where applicable
            String line = inputFile.nextLine();
            token = new StringTokenizer(line, "\t");
            name = token.nextToken();
            position = token.nextToken();
            teamName = token.nextToken();

            gamesPlayedS = token.nextToken();
            goalScoredS=  token.nextToken();
            assistsS =  token.nextToken();
            penaltyMinutesS=  token.nextToken();
            shotOnGoalS =  token.nextToken();
            gameWinningGoalsS=  token.nextToken();

            Integer playedGames = Integer.valueOf ( gamesPlayedS );
            Integer goalsScored = Integer.valueOf( goalScoredS );
            Integer assists = Integer.valueOf(assistsS);
            Integer penaltyMinutes = Integer.valueOf( penaltyMinutesS );
            Integer shotOnGoal = Integer.valueOf(shotOnGoalS);
            Integer gameWinningGoals = Integer.valueOf(gameWinningGoalsS);

            playerRecord = new PlayerRecord(name,position,teamName,playedGames,goalsScored,assists,penaltyMinutes,shotOnGoal,gameWinningGoals);
            // create each playerRecord object
            ns.add(playerRecord);
        }
        inputFile.close();

        //Output
        System.out.println("NHL Results Summary\n");

        //Prints the players with highest points
        System.out.println("Players with highest points: ");
        ns.mostPoints ();
        System.out.println ();

        //Prints the most aggressive players
        System.out.println ("Most aggressive players, their teams and their positions: " );
        ns.mostAggressive ();
        System.out.println ( );

        //Prints the MVPs
        System.out.println ("Most valuable players and their teams: " );
        ns.playerMVP ();
        System.out.println ( );

        //Prints the most promising player
        System.out.println ( "Most promising players and their teams: ");
        ns.mostPromising ();
        System.out.println ( );

        //Prints the most penalty by teams
        System.out.println ( "Teams that had the most number of penalty minutes: ");
        ns.greatPenaltyMins ();
        System.out.println ( );

        //Prints the most game winnings by teams
        System.out.println ( "Teams that had the most number of game winning goals: ");
        ns.MostWinningGoals ();

    }
}
