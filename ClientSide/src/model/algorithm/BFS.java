package model.algorithm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;




public class BFS extends AbstractSearcher implements Serializable{
	 
	 
		  public ArrayList<Action> search(SearchDomain domain) {
		  HashSet<State> closedSet=new HashSet<State>();
		  openList.add(domain.getStartState());
		  while(openList.size()>0){
			  State n=openList.poll();   // dequeue
			  closedSet.add(n);
			  if(n.equals(domain.getGoalState()))
			  {
				  domain.setGoal(n);
				  return backTrace(domain); // back traces through the parents
			  }	
			  HashMap<Action,State> moves= domain.extractSuccessors(n);
			  if (moves!=null)
				  for(Action s : moves.keySet()){
					  State state=moves.get(s);
					  if (state==null)
						 continue;
					  if(!closedSet.contains(state) && !openList.contains(state)){
						  		state.setCameFrom(n);
							  	addToOpenList(state); 
					  } else
						  if (state.GetTotalCost(domain)>(n.GetTotalCost(domain)+state.getCost()))
						  {
							  state.setCameFrom(n);
							  if  (closedSet.contains(state))
								  closedSet.remove(state);
							  if  (!openList.contains(state))
								  addToOpenList(state);
						  }
			  }
		  }
		return null;
	}
}
