import java.text.MessageFormat;
import java.util.Comparator;
import java.util.Scanner;

//Assignment 2
//Written by: Ozwin Neel Lobo (40228757)
//Due Date : 27 Nov 2022
//----------------------------------------------------- 
/**
* Class Team : Provides a implementation of Team
* @author ozwin
*/
public class Team implements Groupable, Cloneable,Comparator<Team> {

	private String teamID;
	private String teamName;
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private double netRunRate;
	private int points;
	private String group;

	/**
	* get the team id of the corresponding team
	*/
	public String getTeamID() {
		return this.teamID;
	}

	private void setTeamID(String teamID) {
		this.teamID = teamID;
	}
	/**
	* get the team name of the corresponding team
	*/
	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		teamName = teamName.replaceAll(" ", "_");
		this.teamName = teamName;
	}
	/**
	* get total games played by  the corresponding team
	*/
	public int getGamesPlayed() {
		return this.gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	/**
	* get games won by the corresponding team
	*/
	public int getGamesWon() {
		return this.gamesWon;
	}

	public int setGamesWon(int gamesWon) {
		return this.gamesWon = gamesWon;
	}
	/**
	* get games lost by the corresponding team
	*/
	public int getGamesLost() {
		return this.gamesLost;
	}

	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}
	/**
	* get points of the corresponding team
	*/
	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	/**
	* get the net run rate of the corresponding team
	*/
	public double getnetRunRate() {
		return this.netRunRate;
	}

	public void setNetRunRate(double netRunRate) {
		this.netRunRate = netRunRate;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	public Team() {
	}

	/**
	* parameterized constructor create a team object
	* @param teamID Unique string id for the team
	* @param teamName Name of the team
	* @param gamesPlayed total games played
	* @param gamesWon games won by the team
	* @param gamesLost games lost by the team
	* @param netRunRate net run rate of the team
	* @param points total points of the team
	*/
	public Team(String teamID, String teamName, int gamesPlayed, int gamesWon, int gamesLost, double netRunRate,
			int points) {
		this.teamID = teamID;
		this.teamName = teamName;
		this.gamesPlayed = gamesPlayed;
		this.gamesLost = gamesLost;
		this.gamesWon = gamesWon;
		this.netRunRate = netRunRate;
		this.points = points;
	}

	/**
	* Copy constructor to copy a team object
	* @param team  object from which details need to be copied
	* @param teamId new ID from copied object
	*/
	public Team(Team team, String teamId) {
		this.teamID = teamId;
		this.teamName = team.getTeamName();
		this.points = team.getPoints();
		this.gamesLost = team.getGamesLost();
		this.gamesWon = team.getGamesWon();
		this.gamesPlayed = team.getGamesPlayed();
		this.netRunRate = team.getnetRunRate();
	}

	/**
	* Clone a team object , need to provide new team id
	*
	*/

	public Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		Team team = (Team) obj;
//		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a new team Id for cloning the team "+team.getTeamName());
//		boolean isValid = false;
		String teamID = "";
		teamID = TournamentResults.takeStringImput();
		team.setTeamID(teamID);
		return team;
	}


	public String toString() {
		return MessageFormat.format(
				"Team ID:{0}\nTeam Name:{1}\nPoints:{2}\nNRR:{3}\nGames Won{4}\nGames Lost:{5}\nGames Played:{6}",
				this.getTeamID(), this.getTeamName(), this.getPoints(), this.getnetRunRate(), this.getGamesWon(),
				this.getGamesLost(), this.getGamesPlayed());
	}
	
	/**
	* Compare of two objects are equal
	*
	* @param obj  team object against which you want to compare
	*/

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Team team = (Team) obj;
		if (this.getTeamName().equals(team.getTeamName()) && this.getGamesLost() == team.getGamesLost()
				&& this.getGamesPlayed() == team.getGamesPlayed() && this.getGamesWon() == team.getGamesWon()
				&& this.getnetRunRate() == team.getnetRunRate() && this.getPoints() == team.getPoints())
			return true;
		return false;
	}

	/**
	* Checks if the team is in same group
	*
	* @param team  team against which you want to test
	*/
	@Override
	public boolean isInTheGroup(Team team) {
		// TODO Auto-generated method stub
		if (this.getGroup().equals(team.getGroup()))
			return true;
		return false;

	}
	/**
	* Compare function for team , used for sorting
	*
	* @param firstTeam  team 1
	* @param secondTeam team 2
	*/
	public int compare(Team  secondTeam,Team firstTeam) {
		int diff=firstTeam.getPoints()-secondTeam.getPoints();
		if(diff!=0)
			return diff;
		return firstTeam.getnetRunRate()>secondTeam.getnetRunRate()?1:-1;
	}
}
