package model.domains;

import java.io.Serializable;

import model.algorithm.SearchDomain;
import model.algorithm.State;


public class MazeGameState extends State implements Serializable {
	private static final long serialVersionUID = 1L;
	

	public int compareTo(State s) {
		if (this.getF_score()>s.getF_score()||this.getState()==9999)
			return 1;
		if (this.getF_score()<s.getF_score())
			return -1;
		else
		{
			if (this.getCost()>s.getCost())
				return 1;
			if (this.getCost()<s.getCost())
				return -1;
			else
				return 0;
		}
	}
	
	//C'tor
	public MazeGameState(State state)
	{
		super(state);
	}
	

	 public MazeGameState (int state,double cost, State cameFrom,int StateRow,int StateColumn)
	{
			super(state,cost,cameFrom,StateRow,StateColumn);
	}
	
	@Override
	public double GetTotalCost(SearchDomain  domain)
	 {
		double sum=0;
		State s=this;
		 while (s.getCameFrom()!=null)
		 {
			 sum+=s.getCost();
		 	 s=s.getCameFrom();
		 }
		 return sum;
		
		
	 }

	public double GetCostToCameFrom(SearchDomain domain) {
		return 3;
	}
	
}

