package model.algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;

import model.domains.SkiGameDomain;






public abstract  class AbstractSearcher implements Searcher {

	
	PriorityQueue<State> openList;

	 public AbstractSearcher() {
	 
		 openList=new PriorityQueue<State>();
	 }

	 protected void addToOpenList(State s) {
	  openList.add(s);
	  }

	
	 
	 
	  public abstract ArrayList<Action> search(SearchDomain domain);


	
}
