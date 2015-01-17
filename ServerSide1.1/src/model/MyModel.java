package model;

import java.util.ArrayList;
import java.util.Observable;
import model.algorithm.Action;
import model.algorithm.SearchDomain;
import model.algorithm.Searcher;




public class MyModel extends Observable implements Model {
	
	
	SearchDomain domain;
	Searcher algorithm;
	Solution solution;
	SolutionManager solutionManager;


	
	public MyModel(){
		
		domain=null;
		algorithm=null;
		
		solutionManager = SolutionManager.getInstance();
	}

	public void selectDomain(SearchDomain domainName) {
	
		this.domain=domainName;
		
	}

	public void selectAlgorithm(Searcher algorithmName) {
		
		this.algorithm=algorithmName;
	}

	public void solveDomain() {

		
		String problemDescription = domain.getProblemDescription();
		this.solution = solutionManager.getSolution(problemDescription);
		if (solution == null) {		
			ArrayList<Action> actions = algorithm.search(domain);
			solution = new Solution();
			solution.setActions(actions);
			solution.setGame(problemDescription);
			solutionManager.addSolution(solution);
		}
		
		this.setChanged();
		this.notifyObservers();
	}
		
	public void doTask() {
		
		try {
			Thread.sleep(20000);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		solveDomain();
		
	}
	
	public Solution getSolution(){
		return solution;
	}

	

}
