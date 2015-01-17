package view;

import model.algorithm.Action;
import model.algorithm.SearchDomain;
import java.util.Observable;
import java.util.Scanner;
import model.Solution;


public class MyConsoleView extends Observable implements View {

	String action;
	
	public void start() {
	
		System.out.println("Welcome to my project");
		action = "";
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Enter command: ");
			action = scanner.nextLine();
			if (!(action.equals("exit")))
			{
				this.setChanged();
				this.notifyObservers();
			}
			if(action.equals("SolveDomainInThread"))
			{
				System.out.println("Enter command CheckIfThreadAlive: ");
			}
				
		   }while (!(action.equals("exit")));
		 
	
		System.out.println("All Threads has been destroyed successfully");
	}	
	
	public void displayCurrentState(SearchDomain DomainName) {
		for (int  i=0;i<10;i++)
		{
			for (int j=0;j<10;j++)
			{
				if(DomainName.getMap()[i][j]==null){
					System.out.print(" |||||||    ");
					continue;}
				if (DomainName.getMap()[i][j].equals(DomainName.getStartState()))
					System.out.print("*("+DomainName.getMap()[i][j].getStateRow()+","+DomainName.getMap()[i][j].getStateColumn()+") "+(int)DomainName.getMap()[i][j].getCost()+"    ");
				else
					System.out.print(" ("+DomainName.getMap()[i][j].getStateRow()+","+DomainName.getMap()[i][j].getStateColumn()+") "+(int)DomainName.getMap()[i][j].getCost()+"    ");
			}
		System.out.println();
		}
	}
						
	public void displaySolution(Solution solution) {
		for(Action a : solution.getActions())
			System.out.println(a);
	}

	public String getUserAction() {
		return action;
	}

	

	@Override
	public void createMazeGame(SearchDomain searchDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGame(int[][] gameBoard,double totalScore) {
		// TODO Auto-generated method stub
		
	}

}