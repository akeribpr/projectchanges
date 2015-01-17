package model;

import java.util.Observer;

import model.algorithm.SearchDomain;
import model.algorithm.Searcher;

import tasks.Task;

public interface Model  extends Task {
	
	
	void selectDomain(SearchDomain domainName);
	void selectAlgorithm(Searcher algorithmName);
	void solveDomain();
	Solution getSolution();
	void addObserver(Observer o);

}
