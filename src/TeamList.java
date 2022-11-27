import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.NoSuchElementException;

//Assignment 2
//Written by: Ozwin Neel Lobo (40228757)
//Due Date : 27 Nov 2022
//----------------------------------------------------- 

/**
 * Class TeamList : Provides a list data structure to implement and manipulate a list of teams
 * @author ozwin
 */
public class TeamList  {
	class TeamNode  implements Cloneable {
		TeamNode nextNode;
		Team team;

		public TeamNode() {
			this.nextNode = null;
			this.team = null;
		}

		public TeamNode(TeamNode nextNode, Team team) {
			this.nextNode = nextNode;
			this.team = team;
		}

		public TeamNode(TeamNode nextNode) {
			this.nextNode = nextNode;
			this.team = nextNode.team;
		}

		public Object clone() throws CloneNotSupportedException {
			Object obj = super.clone();
			TeamNode teamNode = (TeamNode) obj;
			return teamNode;
		}

		public Team getTeam() {
			return this.team;
		}

		public void setTeam(Team team) {
			this.team = team;
		}
	}

	/**
	 * head points to the first element on the TeamList
	 */
	private TeamNode head;

	private int size;

	public int getSize() {
		return this.size;
	}

	public TeamList() {
		this.size = 0;
		this.head = null;
	}

	public TeamList(TeamList teamList) throws CloneNotSupportedException{
		TeamNode currentNode = teamList.head;
		while (currentNode != null) {
			Team tmpteam=(Team)currentNode.getTeam().clone();
			this.addToStart(tmpteam);
			currentNode = currentNode.nextNode;		
		}
	}
	/**
	*provides a string representation of the TeamList class
	*
	*/  
	
	public String toString() {
		TeamNode currentNode = this.head;
		String output="";
		while (currentNode != null) {
			Team tmpteam=currentNode.getTeam();
			output+="\n|Name:"+tmpteam.getTeamName()+" Id:"+tmpteam.getTeamID()+"|\n";
			currentNode = currentNode.nextNode;		
		}
		String outputFinal="Current List Items are : ";
		outputFinal+=output.length()>0?output:"||";
		return outputFinal;
	}

	/**
	*Inserts a  team object at the beginning of the team list
	*
	* @param team object which need to be inserted
	*/  
	public void addToStart(Team team) {
		TeamNode newNode = new TeamNode(null, team);
		if (this.head != null) {
			newNode.nextNode = head;
		}
		head = newNode;
		this.size++;
	}

	/**
	*Inserted provided team object at corresponding position
	*
	* @param team object which need to be inserted
	* @index position at which you want to insert the team 
	*/  
	
	public void insertAtIndex(Team team, int index) {
		if (index < 0 || index > this.size ) {
			throw new NoSuchElementException("Index specified doesn't exists!");
		}
		TeamNode currentNode = head;
		int iterator = 1;
		while (iterator < index && currentNode != null) {
			currentNode = currentNode.nextNode;
			iterator++;
		}
		TeamNode newNode = new TeamNode(null, team);
		if (index == 1) {
			newNode.nextNode = this.head;
			this.head = newNode;
		} else {
			newNode.nextNode = currentNode.nextNode;
			currentNode.nextNode = newNode;
		}
		this.size++;
	}

	/**
	*deleted a team object from given  position
	*
	* @index position from which you want to replace the team 
	*/  
	public void deleteFromIndex(int index) {
		if (index < 0 || index > this.size ) {
			throw new NoSuchElementException("Index specified doesn't exists!");
		}
		if (index == 1) {
			TeamNode currentNode = head;
			head = currentNode.nextNode;
			currentNode = null;
		} else {
			int iterator = 1;
			TeamNode currentNode = null, prevNode = head;
			while (iterator == index - 1 || prevNode.nextNode == null) {
				prevNode = prevNode.nextNode;
				iterator++;
			}
			currentNode = prevNode.nextNode;
			prevNode.nextNode = currentNode.nextNode;
			currentNode = null;
		}
		this.size--;
	}

	/**
	*delete a team from the list from the beginiing
	*
	*/
	
	public void deleteFromStart() {
		if (this.size == 0) {
			return;
		}
		TeamNode currentNode = head;
		head = currentNode.nextNode;
		currentNode = null;
		this.size--;
	}

	/**
	*replaces provided team object at corresponding position
	*
	* @param team object which need to be replaced
	* @index position at which you want to replace the team 
	*/  
	public void replaceAtIndex(Team team, int index) {
		if (index < 0 || index >this.size ) {
			return;
		}
		TeamNode currentNode = head;
		int iterator = 1;
		while (iterator <index && currentNode != null) {
			currentNode = currentNode.nextNode;
			iterator++;
		}
		currentNode.setTeam(team);
	}

	/**
	*find the team in the current team list
	*
	* @param teamID Id of the team which you want to check
	*/ 
	public Team find(String teamID) {
		TeamNode currentNode = head;
		int iterator = 1;
		while (currentNode != null) {
			Team team = currentNode.getTeam();
			if (team != null && team.getTeamID().equals(teamID)) {
				return currentNode.getTeam();
			}
			currentNode = currentNode.nextNode;
			iterator++;
		}
		System.out.println(String.format("Couldn't find the element specified after %d tries", iterator));
		return null;
	}

	/**
	*checks if the teamID exist in the current team list
	*
	* @param teamID Id of the which you want to check
	*/
	public boolean contains(String teamID) {
		Team team = this.find(teamID);
		if (team == null)
			return false;
		return true;
	}

	/**
	*Check if 2 team lists are equals , equality is compared on the basis of same size and same teams with any order in two list
	*
	* @param newList team list against which you want to compare
	*/
	public boolean equals(TeamList newList) {
		if (this.getSize() != newList.getSize())
			return false;
		// security breach
		TeamNode currentNode = head;
		while (currentNode != null) {
			if (!newList.checkIfTeamExist(currentNode.getTeam()))
				return false;
			currentNode = currentNode.nextNode;
		}
		return true;
	}
	
	/**
	*Check if the team exist in the list
	*
	* @param team team object for which you want to check , Eqals defination of Team entity will be used
	*/

	public boolean checkIfTeamExist(Team team) {
		TeamNode currentNode = head;
		while (currentNode != null) {
			if (currentNode.getTeam().equals(team))
				return true;
			currentNode = currentNode.nextNode;
		}
		return false;
	}
	/**
	* Find a team in the list by name
	*
	* @param teamName name of the team which you want to find 
	*/
	public Team findByTeamName(String teamName) {
		TeamNode currentNode = head;
		int iterator = 1;
		while (currentNode != null) {
			Team team = currentNode.getTeam();
			if (team != null && team.getTeamName().equals(teamName)) {
				return currentNode.getTeam();
			}
			currentNode = currentNode.nextNode;
			iterator++;
		}
		System.out.println(String.format("Couldn't find the element specified after %d tries", iterator));
		return null;
	}
	/**
	* Checks if the team qualifies for the knockout game
	*
	* @param teamName name of the team for which you want to check knockout status
	*/
	public String checkIfQualifies(String teamName) {
		Team team = findByTeamName(teamName);
		if (team == null)
			return "";
		String output = "";
		TeamNode currentNode = head;
		ArrayList<Team> qualifiers = new ArrayList<Team>();
		while (currentNode != null) {
			Team currentTeam = currentNode.getTeam();
			// check only if they are in same group
			if (team.getGroup().equals(currentTeam.getGroup())) {
				qualifiers.add(currentTeam);
			}
			currentNode = currentNode.nextNode;
		}
		qualifiers.sort(team);
		// check if qualifies
		if (qualifiers.get(0).getTeamName().equals(teamName)) {
			output = qualifiers.get(0).getPoints() > qualifiers.get(1).getPoints()
					? MessageFormat.format(
							"{0} qualifies for the second round as it has more points than other {1} teams", teamName,
							qualifiers.size()-1)
					: MessageFormat.format("{0} qualifies for the second round as it has higher run rate", teamName);
		} else if (qualifiers.get(1).getTeamName().equals(teamName)) {
			if (qualifiers.size() > 2 && qualifiers.get(1).getPoints() == qualifiers.get(2).getPoints()) {
				output = MessageFormat.format("{0} qualifies for the second round as it has higher run rate", teamName);
			} else {
				output = MessageFormat.format(
						"{0} qualifies for the second round as it has more points than other {1} teams", teamName,
						qualifiers.size()-2);
			}
		} else {
			if (team.getPoints() == qualifiers.get(1).getPoints()) {
				//run rate issue
				output = MessageFormat.format(
						"{0} can't qualify for the second round as it doesn't have high enough run rate ", teamName);
			} else {
				//points issue
				output = MessageFormat
						.format("{0} can't qualify for the second round as it doesn't have enough points ", teamName);
			}
		}
		return output;
	}
}
