package model.algorithm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;



public class AStar extends AbstractSearcher implements Serializable{
	
	 
	 private double heuristic_cost_estimate(SearchDomain  domain,  State state) // estimate time to goal state
	 {
		 double a=0,b=0;
		 for(int i=domain.getGoalState().getStateRow();i>state.getStateRow();i--)
		 {
			 if (domain.getMap()[i][state.getStateColumn()]!=null)
				 a+=domain.getMap()[i][state.getStateColumn()].getCost();
			 else
				 a+=3;
		 }
		 if (state.getStateColumn()<domain.getGoalState().getStateColumn())
			 for(int i=domain.getGoalState().getStateColumn();i>state.getStateColumn();i--)
			 {
				 if (domain.getMap()[domain.getGoalState().getStateRow()][i]!=null)
					 b+=domain.getMap()[domain.getGoalState().getStateRow()][i].getCost();
				 else
					 b+=3;
			 }
		 if (state.getStateColumn()>domain.getGoalState().getStateColumn()) 
			 for(int i=domain.getGoalState().getStateColumn();i<state.getStateColumn();i++)
			 {
				 if(domain.getMap()[domain.getGoalState().getStateRow()][i]!=null)
					 b+=domain.getMap()[domain.getGoalState().getStateRow()][i].getCost();
				 else
					 b+=3;
			 }
		 return Math.sqrt(Math.pow(a,2)+Math.pow(b,2)); 
	 }
	 
	 private double G_score(SearchDomain  domain,  State state)// cost from state to start 
		{
			
			return state.GetTotalCost(domain);
			
		}
	 
	 private double F_score(SearchDomain  domain,  State state)
	 {
		 return G_score(domain,state)+heuristic_cost_estimate(domain,state);		 
	 }

	@Override
	public ArrayList<Action> search(SearchDomain domain) { 
		domain.getStartState().setF_score(F_score(domain,domain.getStartState()));
		HashSet<State> closedSet=new HashSet<State>();
		openList.add(domain.getStartState());
		while(openList.size()>0){
			 State current=openList.poll(); // dequeue
			 if (current==domain.getGoalState())
				 return backTrace(domain);		// back traces through the parents
			 closedSet.add(current);
			 HashMap<Action,State> moves= domain.extractSuccessors(current);
			  if (moves!=null)
				  for(Action s : moves.keySet()){
					  State state=moves.get(s);
					  if(closedSet.contains(state)||state==null)
						  continue;
					  state.setCameFrom(current);
					  double tentative_g_score=current.getG_score()+state.GetCostToCameFrom(domain);
					  if (!openList.contains(state)||tentative_g_score<state.getG_score()){
						  state.setG_score(tentative_g_score);
						  state.setF_score(state.getG_score()+heuristic_cost_estimate(domain,state));
						  if (!openList.contains(state))
							  openList.add(state);
					  }
						  else
							  if (!openList.contains(state))
								  state.setCameFrom(null);
				  }
		}
		return null;
	}


	 
}