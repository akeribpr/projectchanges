package model;


import java.util.Observable;

import networking.Client;
import model.algorithm.SearchDomain;
import model.algorithm.Searcher;



public class MyModel extends Observable implements Model {
	
	
	SearchDomain domain;
	Searcher algorithm;
	Solution solution;
	Problem problem;
	SearchAlgorithmsFactory algorithmsFactory;
	DomainFactory domainFactory;
	HeuristicFactory heuristicFactory;
	String domainName;
	double totalScore;
	
	public MyModel(){
		
		domain=null;
		algorithm=null;
		problem = new Problem();
		algorithmsFactory = new SearchAlgorithmsFactory();
		domainFactory = new DomainFactory();
		heuristicFactory = new HeuristicFactory();
		totalScore=0;
	
	}

	public void selectDomain(String domainName) {
		
		SearchDomain s=domainFactory.createDomain(domainName);
		if (s!=null) 
			domain=s;
		problem.setDomainName(domain);
		this.setChanged();
		this.notifyObservers(4);
	}

	public void selectAlgorithm(String algorithmName) {
		
		
		this.algorithm = algorithmsFactory.createAlgorithm(algorithmName, domainName);
		/*Searcher s=algorithmsFactory.createAlgorithm(algorithmName);
		if (s!=null) 
			algorithm=s;*/
		problem.setAlgorithmName(algorithm);
		this.setChanged();
		this.notifyObservers(2);
	}

	public void solveDomain() {
		
		
		Client client = new Client();
		solution = client.getSolution(problem);
		
		this.setChanged();
		this.notifyObservers(1);
	}
	
	public Solution getSolution(){
		return solution;
	}

	@Override
	public void selectMove(String moveName) {
		this.domain.setStart(moveName);
		totalScore+=this.domain.getStartState().GetCostToCameFrom(domain);
		this.setChanged();
		this.notifyObservers(2);
	}


	public SearchDomain getDomain() {
		return domain;
	}
	
	@Override
	public double getTotalScore() {
		return totalScore;
	}

}
