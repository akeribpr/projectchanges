package model.algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;






public abstract  class AbstractSearcher implements Searcher {

	
	PriorityQueue<State> openList;

	 public AbstractSearcher() {
	 
		 openList=new PriorityQueue<State>();
	 }

	 protected void addToOpenList(State s) {
	  openList.add(s);
	  }

	
	 protected ArrayList<Action> backTrace(SearchDomain domain)
	 {
		 ArrayList<Action> moves = new ArrayList<Action>();
		 
		 State current=domain.getGoalState();
		 while (current.getCameFrom()!=null)
		 {
			 switch (current.getStateColumn()-current.getCameFrom().getStateColumn()){
			 case 2: {
				 	Action a=new Action("turn diagonal right to: "+current.getState());
				 	moves.add(a);
			 		break;}
			 case 1:{
				 	Action a=new Action("turn right to: "+current.getState());
				 	moves.add(a);
				 	break;}
			 case 0:{
				 	Action a=new Action("turn stright to: "+current.getState());
				 	moves.add(a);
				 	break;}
			 case -1:{
				 	Action a=new Action("turn left to: "+current.getState());
				 	moves.add(a);
				 	break;}
			 case -2:{
				 	Action a=new Action("turn diagonal left to: "+current.getState());
				 	moves.add(a);
				 	break;}
			 }
			 current=current.getCameFrom();
		 }
		 return moves;
	 }
	 
	  public abstract ArrayList<Action> search(SearchDomain domain);


	
}
