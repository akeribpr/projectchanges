package model;

import java.util.Observer;

import model.algorithm.SearchDomain;



public interface Model   {
	
	void selectDomain(String domainName);
	void selectAlgorithm(String algorithmName);
	void solveDomain();
	Solution getSolution();
	void addObserver(Observer o);
	void selectMove(String moveName);
	SearchDomain getDomain();
	double getTotalScore() ;
	

}
