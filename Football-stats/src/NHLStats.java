/**
 * Author @ Sachit Singh Chawla, B00865842
 * This programs creates a list which calculates the most points by players, most aggressive player, most valuable player,
 * most promising,  most Penalty wins by teams and the most winning goals by teams
 */

import java.util.ArrayList;

public class NHLStats {
    private List<PlayerRecord> record;

    //Constructor
    public NHLStats(){
        record=new List<PlayerRecord> ();
    }
    //adds player to the record
    public void add(PlayerRecord pr){
        record.add ( pr );
    }
    //Checks if the record is empty
    public boolean isEmpty(){
        return record.isEmpty ( );
    }
    //checks if the player is in the record
    public boolean contains (PlayerRecord pr){
        return  record.contains ( pr );
    }
    //first record
    public PlayerRecord first(){
        return record.first ( );
    }
    // returns the next player
    public PlayerRecord next(){
        return record.next ( );
    }
    // enumerates the data of the player
    public void enumerate(){
         record.enumerate ( );
    }

    /**
     * This methods goes on each and every row of the record and finds the max points (assists+goal scored) and then
     * prints the name and the team name of the player based on the max scored by the player
     */
    public void mostPoints(){
        if( record.isEmpty ( ) ){return;}
        PlayerRecord rec =  record .first ();
        int maxPoints = 0;
        while(rec!=null) {
            if ( rec.getAssists ( )+rec.getGoalScored () > maxPoints ) {
                maxPoints = rec.getAssists ( )+rec.getGoalScored ();
            }
            rec= record.next ();
        }
        //initalizes to the first element
        rec = record.first ();
        //prints the name and team name of the player
        while(rec!=null){
            if(rec.getAssists ( )+rec.getGoalScored ()==maxPoints){
                System.out.println (rec.getName () + " "+rec.getTeamName ());
            }
            rec=record.next ();
        }

    }

    /**
     *  This methods goes on each and every row of the record and finds the max penalty minutes by the players and then
     *   prints the name and the team name  and position of the player based on the max penalty minutes by the player
     */

    public void mostAggressive(){
        if( record.isEmpty ( ) ){return;}
        PlayerRecord rec =  record .first ();
        int maxMinutes = 0;
        while(rec!=null) {
            if ( rec.getPenaltyMinutes ( ) > maxMinutes ) {
                maxMinutes = rec.getPenaltyMinutes ( );
            }
            rec= record.next ();
        }
        //prints the name and team name and position
        rec = record.first ();
        while(rec!=null){
            if(rec.getPenaltyMinutes ()==maxMinutes){
                System.out.println (rec.getName () + " "+rec.getTeamName ()+" "+
                        rec.getPosition () );
            }
            rec=record.next ();
        }
    }

    /**
     * This methods goes on each and every row of the record and finds the max winning goals by the players and then
     *  prints the name and the team name   of the player based on the max winning goals by the player
     */
    public void playerMVP(){
        if( record.isEmpty ( ) ){return;}
        PlayerRecord rec =  record .first ();
        int maxGoals = 0;
        while(rec!=null) {
            if ( rec.getGameWinningGoals () > maxGoals ) {
                maxGoals = rec.getGameWinningGoals ( );
            }
            rec= record.next ();
        }
        //prints the name and team name
        rec = record.first ();
        while(rec!=null){
            if(rec.getGameWinningGoals ()==maxGoals){
                System.out.println (rec.getName () + " "+rec.getTeamName ());
            }
            rec=record.next ();
        }

    }

    /**
     * This method find the most promising player based shots on goal. First the while finds max shots by player and then second while loop prints
     * name and team name based on max shots by player.
     */
    public void mostPromising (){
        if( record.isEmpty ( ) ){return;}
        PlayerRecord rec =  record .first ();
        int maxShots = 0;
        while(rec!=null) {
            if ( rec.getShotOnGoal ()> maxShots ) {
                maxShots = rec.getShotOnGoal ( );
            }
            rec= record.next ();
        }
        //prints the name and team name
        rec = record.first ();
        while(rec!=null){
            if(rec.getShotOnGoal ()==maxShots){
                System.out.println (rec.getName () + " "+rec.getTeamName ());
            }
            rec=record.next ();
        }

    }

    /**
     * This Program finds the most penalty by teams
     * PART 1: first creates an array and stores all the distinct teams in the array by going on all the list one at a time
     * PART 2: then creates an array adds all the penalties to the respective teams:  it goes on each and every list checks if the list's team name equal to the
     * team name in the array list, if its equal it adds the lists penalty or else moves forward and goes on until all matches are found
     * PART 3: finds the max of penalties
     * PART 4: prints all teams with max penalties.
     */

    public void greatPenaltyMins(){
        ArrayList<String> teams = new ArrayList<> (  );

        PlayerRecord rec =  record.first ();
        //Creates an array list with distinct teams
        while(rec!=null){
            if( !teams.contains ( rec.getTeamName ()) ){
                teams.add ( rec.getTeamName());
            }
            rec = record.next ( );
        }
        ////adds all the penalty to their respective teams
        int [] penalty = new int[teams.size ( )];
        rec = record.first ();
        while(rec!=null) {
            for (int i = 0; i < teams.size ( ); i++) {
                if ( teams.get ( i ).equals ( rec.getTeamName ( )) ) {
                    penalty[i]=penalty[i]+ rec.getPenaltyMinutes ( );
                }
            }
            rec= record.next ();
        }
        // // finds the max penalty
        int max  = penalty[0];
        for (int j : penalty) {
            if ( j > max ) {
                max = j;
            }
        }
        //prints the teams with the max penalties
        for (int i = 0; i < penalty.length; i++) {
            if(penalty[i]==max){
                System.out.println (teams.get ( i ) );
            }
        }
    }

    /**
     *  This Program finds the most penalty by teams
     * PART 1: first creates an arraylist and stores all the distinct teams in the array by going on all the list one at a time
     * PART 2: then creates an array adds all the game winning goals to the respective teams:  it goes on each and every list checks if the list's team name equal to the
     * team name in the array list, if its equal it adds the list's game winning goal or else moves forward and goes on until all matches are found
     * PART 3: finds the max of game winning goal
     * PART 4: prints all teams with max game winning goal.
     */
    public void MostWinningGoals(){
        ArrayList<String> teams = new ArrayList<> (  );

        PlayerRecord rec =  record.first ();
        //Creates an array list with distinct teams
        while(rec!=null){
            if( !teams.contains ( rec.getTeamName ()) ){
                teams.add ( rec.getTeamName());
            }
            rec = record.next ( );
        }
        //adds all the game winnings to their respective teams
        int [] gameWinnings = new int[teams.size ( )];
        rec = record.first ();
        while(rec!=null) {
            for (int i = 0; i < teams.size ( ); i++) {
                if ( teams.get ( i ).equals ( rec.getTeamName ( )) ) {
                    gameWinnings[i]=gameWinnings[i]+ rec.getGameWinningGoals ( );
                }
            }
            rec= record.next ();
        }
        // finds the max game winnings
        int max  = gameWinnings[0];
        for (int j : gameWinnings) {
            if ( j > max ) {
                max = j;
            }
        }
        //Prints the teams with max game winnings
        for (int i = 0; i < gameWinnings.length; i++) {
            if(gameWinnings[i]==max){
                System.out.println (teams.get ( i ) );
            }
        }
    }
}
