package model.domains;

import model.algorithm.HeuristicAlgorithmParam;
import model.algorithm.SearchDomain;
import model.algorithm.State;

public class HeuristicDomainParam implements HeuristicAlgorithmParam {

	@Override
	public double heuristic_cost_estimate(SearchDomain domain, State state) {
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
}

