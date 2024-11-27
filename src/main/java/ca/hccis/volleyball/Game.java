package ca.hccis.volleyball;

import ca.hccis.util.CisUtility;

public class Game {

    private static final int  MAX = 3;
    private String team1Name;
    private String team2Name;
    private int team1Score=0;
    private int team2Score=0;
    private boolean gameOver = false;
    private String winningTeam = "";

    public Game() {
    }

    public void start(){
        team1Name = CisUtility.getInputString("Team 1 name");
        team2Name = CisUtility.getInputString("Team 2 name");

        team1Name = CisUtility.convertToFirstLetterUppercase(team1Name);
        team2Name = CisUtility.convertToFirstLetterUppercase(team2Name);


        System.out.println();        //TODO run the game
        //while not gameOver
        //--getNextPointFromUser
        //--display
        //--checkForWinner
        while (!gameOver) {
            getNextPointFromUser();
            checkForWinner();
            display();
        }

    }

    /**
     * Ask which team scored point and adjust scores.
     * Check for a winner
     */
    public void getNextPointFromUser() {

        //TODO Ask for points
        String whichTeam;
        
        whichTeam = CisUtility.getInputString("Which team scored a point?");
        while (!whichTeam.equalsIgnoreCase(team1Name) && !whichTeam.equalsIgnoreCase(team2Name)) {
            whichTeam = CisUtility.getInputString("That's not a team!  Please enter the name of the team that scored the point: ");
        }
        if (whichTeam.equalsIgnoreCase(team1Name)) {
            team1Score++;
        } else {
            team2Score++;
        } 

    }

    /**
     * Check to see if someone has reached max and is ahead by 2
     * If so assign the winner
     * and set gameOver to true.
     */
    public void checkForWinner(){

        //TODO check for winner
        if (team1Score >= MAX && (team1Score - team2Score) >= 2){
            winningTeam = team1Name;
            gameOver = true;
        } else if (team2Score >= MAX && (team2Score - team1Score) >=2){
            winningTeam = team2Name;
            gameOver = true;
        }

    }

    public void display() {
        System.out.println(this.toString());
    }

    public String toString() {

        String currentGameStatus = "In progress";
        if (gameOver) {
            currentGameStatus = "Game Over!  Winning team: " + winningTeam;
        }

        //TODO If game over, change the game status to Winner: + winning team name

        String output = ""
                + "\n" + team1Name +": "+team1Score+ "\n"
                + "\n" + team2Name +": "+team2Score+ "\n"
                + currentGameStatus;
        return output;
    }


}
