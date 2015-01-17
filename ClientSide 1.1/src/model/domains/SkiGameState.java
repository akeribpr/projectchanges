package model.domains;

import java.io.Serializable;

import model.algorithm.SearchDomain;
import model.algorithm.State;


public class SkiGameState extends State implements Serializable {
	
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
	public SkiGameState(State state)
	{
		super(state);
	}
	
	
	
	 public SkiGameState (int state,double cost, State cameFrom,int StateRow,int StateColumn)
	{
			super(state,cost,cameFrom,StateRow,StateColumn);
	}
	
	@Override
	public double GetTotalCost(SearchDomain  domain)
	 {
		double sum=0;
		SkiGameState s=this;
		 while (s.getCameFrom()!=null)
		 {
			 sum+=s.GetCostToCameFrom(domain);
		 	 s=(SkiGameState) s.getCameFrom();
		 	 
		 }
		 return sum;
	 }
	
	
	public double GetCostToCameFrom(SearchDomain  domain)
	 {
		double  a=0,b=0;
		SkiGameState s;
		s=(SkiGameState)this.getCameFrom();
		int col=s.getStateColumn();
		int row=this.getStateRow();
		if (col ==this.getStateColumn())
			return this.getCost();
		if (domain.getMap()[row][col]!=null)
			a =domain.getMap()[row][col].getCost();
		else
			a+=3;
		if  (col < this.getStateColumn())
			for (int i=col+1;i<=this.getStateColumn();i++)
				if(domain.getMap()[row][i]!=null)
					b+=domain.getMap()[row][i].getCost();
				else 
					b+=3;
		else
			for (int i=col-1;i>=this.getStateColumn();i--)
				if(domain.getMap()[row][i]!=null)
					b+=domain.getMap()[row][i].getCost();
				else
					b+=3;
		return Math.sqrt(Math.pow(a,2)+Math.pow(b,2)); 
	 }
}

	

