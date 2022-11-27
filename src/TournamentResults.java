import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Assignment 2
//Written by: Ozwin Neel Lobo (40228757)
//Due Date : 27 Nov 2022
//----------------------------------------------------- 
/**
 * TournamentResults driver class for the Assignment2
 * @author ozwin
 */

public class TournamentResults {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws CloneNotSupportedException {

		// TODO Auto-generated method stub
		try {
			TeamList firstList = new TeamList();
			Team d1	= new Team("Id1", "ENGLAND", 5, 4, 1, 2.464, 8);
			d1.setGroup("A");
			firstList.addToStart(d1);
			
			Team d2 = new Team("Id2", "AUSTRALIA", 5, 4, 1, 1.216, 8);
			d2.setGroup("A");
			firstList.addToStart(d2);
			
			Team d3 = new Team("Id3", "SOUTH_AFRICA", 5, 4, 1, 0.739, 8);
			d3.setGroup("A");
			firstList.addToStart(d3);
			
			Team d4 = new Team("Id4", "SRI_LANKA", 5, 2, 3, -0.269, 4);
			d4.setGroup("A");
			firstList.addToStart(d4);
			
			Team d5 = new Team("Id5", "WEST_INDIES", 5, 1, 4, -1.641, 2);
			d5.setGroup("A");
			firstList.addToStart(d5);
			
			Team d6 = new Team("Id6", "BANGALDESH", 5, 0, 5, -2.383, 0);
			d6.setGroup("A");
			firstList.addToStart(d6);
			
			Team d7	= new Team("Id7", "PAKISTAN", 5, 5, 0, 1.583, 10);
			d7.setGroup("B");
			firstList.addToStart(d7);
			
			Team d8 = new Team("Id8", "NEW_ZELAND", 5, 4, 1, 1.162, 8);
			d8.setGroup("B");
			firstList.addToStart(d8);
			
			Team d9 = new Team("Id9", "INDIA", 5, 3, 2, 1.747, 6);
			d9.setGroup("B");
			firstList.addToStart(d9);
			
			Team d10 = new Team("Id10", "AFGANISTAN", 5, 2, 3, 1.053, 4);
			d10.setGroup("B");
			firstList.addToStart(d10);
			
			Team d11 = new Team("Id11", "NAMIBIA", 5, 1, 4, -1.890, 2);
			d11.setGroup("B");
			firstList.addToStart(d11);
			
			Team d12 = new Team("Id12", "SCOTLAND", 5, 0, 5, -3.543, 0);
			d12.setGroup("B");
			firstList.addToStart(d12);
			
			System.out.println(firstList);

			System.out.println("Enter the number of team participating");
			int teamCount = Integer.parseInt(scanner.nextLine());
			for (int i = 0; i < teamCount; i++) {
				System.out.println(String.format("Please rnter details of Team: %d", i + 1));
				System.out.println("Team group	  :");
				String group = scanner.nextLine();
				System.out.println("Team ID		  :");
				String teamID = scanner.nextLine();
				System.out.println("Team name	  :");
				String teamName = scanner.nextLine();
				System.out.println("Total matched :");
				int matchedPlayed = Integer.parseInt(scanner.nextLine());
				System.out.println("Matches won	  :");
				int matchesWon = Integer.parseInt(scanner.nextLine());
				System.out.println("Matches lost  :");
				int matchesLost = Integer.parseInt(scanner.nextLine());
				System.out.println("Net run rate  :");
				double netRunRate = Double.parseDouble(scanner.nextLine());
				System.out.println("Points  	  :");
				int points = Integer.parseInt(scanner.nextLine());
				System.out.println("***************************************************");
				Team team = new Team(teamID, teamName, matchedPlayed, matchesWon, matchesLost, netRunRate, points);
				team.setGroup(group);
				firstList.addToStart(team);
			}
			
			System.out.println("Enter the number of teams for whom you want to check qualification status.");
			int requestCount = Integer.parseInt(scanner.nextLine());
			ArrayList<String> reuqests = new ArrayList<String>();
			reuqests.add("AUSTRALIA");
			reuqests.add("NEW_ZELAND");
			reuqests.add("NAMIBIA");
			reuqests.add("SOUTH_AFRICA");

			for (int i = 0; i < requestCount; i++) {
				System.out.println("Enter team name :");
				String request = scanner.nextLine();
				reuqests.add(request);
			}
			System.out.println("Internaly using Comparator for sorting teams");
			for (int i = 0; i < reuqests.size(); i++) {
				String output = firstList.checkIfQualifies(reuqests.get(i));
				System.out.println(output);
			}
			System.out.println("Search functionality, enter the number of teamIds you wish to search");
			int searchCounts = Integer.parseInt(scanner.nextLine());
			for (int i = 0; i < searchCounts; i++) {
				System.out.println("Enter team ID  :");
				String teamID = scanner.nextLine();
				Team team = firstList.find(teamID);
				System.out.println(team);
				System.out.println("***************************************************");
			}

			System.out.println("Demoing team functionalities");
			System.out.println("***************************************************");
			System.out.println("Team 1:");
			Team t1 = new Team("uniqueID1", "Demo team 1", 5, 5, 0, 1.200, 10);
			System.out.println("Using toString() from Team method");
			System.out.println(t1);
			System.out.println("***************************************************");
			System.out.println("Demoing copy constructor");
			Team t2 = new Team(t1, "uniqueId2");
			System.out.println("Set copied object name to demo 2");
			t2.setTeamName("Demo team 2");
			System.out.println(t2);
			System.out.println("***************************************************");
			System.out.println("Demoing constructor with team object");
			Team t3 = (Team) t2.clone();
			System.out.println("Original object: t2");
			System.out.println(t2);
			System.out.println("***************************************************");
			System.out.println("Cloned object: t3");
			System.out.println(t3);
			System.out.println("***************************************************");
			System.out.println("Checking equal operator for team comparison, for t2 and t3 object");
			if (t2.equals(t3)) {
				System.out.println("Yes, they are!!!");
			} else
				System.out.println("No, they don't!!!");
			System.out.println("Now let's change team3 name with a suffix 'cloned' then compare");
			t3.setTeamName(t3.getTeamName() + "-cloned");
			if (t2.equals(t3)) {
				System.out.println("Yes, they are!!!");
			} else
				System.out.println("No, they don't!!!");
			System.out.println("***************************************************");
			System.out.println("Let's test isInTheGroup method");
			System.out.println("Let's set t2 team to \"A\" and t3 team to \"B\"");
			t2.setGroup("A");
			t3.setGroup("B");
			if (t2.isInTheGroup(t3))
				System.out.println("T3 is not in the same group");
			else
				System.out.println("T3 is in the same group");
			System.out.println("***************************************************");
			System.out.println("Now set t3 team to \"A\"");
			t3.setGroup("A");
			if (t2.isInTheGroup(t3))
				System.out.println("T3 is not in the same group");
			else
				System.out.println("T3 is in the same group");
			System.out.println("***************************************************");
			t1.setTeamName("T1");
			t2.setTeamName("T2");
			t3.setTeamName("T3");

			System.out.println("Lets' test some list functionalities , rename team names to their respective object names");
			System.out.println("Lets' add t2 and t3 to the list called demoList using insertAtStart functionality");
			TeamList demoList = new TeamList();
			demoList.addToStart(t2);
			demoList.addToStart(t3);
			System.out.println(demoList);
			System.out.println("Lets' add t1 at index 1 using insertAtIndex functionaity (1-2)");
			demoList.insertAtIndex(t1, 2);
			System.out.println(demoList);
			System.out.println("Lets' delete t3 from 3rd index using deleteFromIndex functionaity (1-3)");
			demoList.deleteFromIndex(3);
			System.out.println(demoList);
			System.out.println("Lets' delete t1 from the beginning using deleteFromStart functionaity (1-2)");
			demoList.deleteFromStart();
			System.out.println(demoList);
			System.out.println(
					"Lets' replace t2 object the list with the t1 object using replaceAtIndex functionaity (1)");
			demoList.replaceAtIndex(t1, 1);
			System.out.println(demoList);
			System.out.println("Let's test functionality to check if \"randomId\" team id is present in the team");
			System.out.println(demoList);
			if (demoList.contains("randomId"))
				System.out.println("randomId exist in th team list");
			else
				System.out.println("randomId doesn't exist in th team list");
			System.out.println("creating demo list 2 with deep copies , note ypu have to provide new id for copied teams");
			TeamList demoList2 = new TeamList(demoList);
			System.out.println("List 1");
			System.out.println(demoList);
			System.out.println("List 2");
			System.out.println(demoList2);
			System.out.println("That's all!,Exiting the application");

		} catch (NoSuchElementException exception) {
			System.out.println(String.format("Exiting application!: Error: %s", exception.toString()));

		} finally {
			
		}
		scanner.close();
	}
	public static String takeStringImput() {
		String input=scanner.nextLine();
		return input;
	}
}
