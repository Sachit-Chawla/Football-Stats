/**
 * Author @ Sachit Singh Chawla
 * Thus file creates player record with name,position, games played, goals scored, assists, penalty minute, shot on goal, and game wining goals
 */
public class PlayerRecord {
    private String name;
    private String position;
    private String teamName;
    private int gamesPlayed;
    private int goalScored;
    private int assists;
    private int penaltyMinutes;
    private int shotOnGoal;
    private int gameWinningGoals;

//Constructor which creates a player record
    public PlayerRecord ( String name, String position, String teamName,
                          int gamesPlayed, int goalScored, int assists,
                          int penaltyMinutes, int shotOnGoal, int gameWinningGoals )
    {
        this.name = name;
        this.position = position;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.goalScored = goalScored;
        this.assists = assists;
        this.penaltyMinutes = penaltyMinutes;
        this.shotOnGoal = shotOnGoal;
        this.gameWinningGoals = gameWinningGoals;
    }

    @Override
    public String toString ()
    {
        return "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", teamName='" + teamName + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", goalScored=" + goalScored +
                ", assists=" + assists +
                ", penaltyMinutes=" + penaltyMinutes +
                ", shotOnGoal=" + shotOnGoal +
                ", gameWinningGoals=" + gameWinningGoals;
    }
    //Getters
    public String getName () {return name;}
    public String getPosition () {return position;}
    public String getTeamName () {return teamName;}
    public int getGamesPlayed () {return gamesPlayed;}
    public int getGoalScored () {return goalScored;}
    public int getAssists () {return assists;}
    public int getPenaltyMinutes () {return penaltyMinutes;}
    public int getShotOnGoal () {return shotOnGoal;}
    public int getGameWinningGoals () {return gameWinningGoals;}


    //Checks if one player record is equal to another
    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( ! (o instanceof PlayerRecord) ) return false;
        PlayerRecord that = (PlayerRecord) o;
        return getGamesPlayed ( ) == that.getGamesPlayed ( ) && getGoalScored ( ) == that.getGoalScored ( ) && getAssists ( ) == that.getAssists ( )
                && getPenaltyMinutes ( ) == that.getPenaltyMinutes ( ) && getShotOnGoal ( ) == that.getShotOnGoal ( )
                && getGameWinningGoals ( ) == that.getGameWinningGoals ( ) && getName ( ).equals ( that.getName ( ) )
                && getPosition ( ).equals ( that.getPosition ( ) ) && getTeamName ( ).equals ( that.getTeamName ( ) );
    }




}
