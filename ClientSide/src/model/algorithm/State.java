package model.algorithm;

import java.io.Serializable;

public abstract class State implements Comparable<State>,Serializable {
	
	private int state;    // the state represented by a string
    private double cost;     // cost to reach this state
    private State cameFrom;  // the state we came from to this state
    public int StateRow;
    public int StateColumn;
	double g_score;
	double f_score;
	

    public State(int state,double cost, State cameFrom,int StateRow,int StateColumn){    // CTOR    
        this.state = state;
        this.cost = cost;
        this.cameFrom = cameFrom;
        this.StateRow=StateRow;
    	this.StateColumn=StateColumn;
    	this.g_score=0;
    	this.f_score=0;
    }
    
    public State(State state)
    {
    	this.state=state.state;
    	this.cost=state.cost;
    	this.cameFrom=state.cameFrom;
    	this.StateRow=state.StateRow;
      	this.StateColumn=state.StateColumn;
      	this.g_score=0;
    	this.f_score=0;
    }
   
    public abstract double GetCostToCameFrom(SearchDomain  domain);
	 
    
    @Override
    public boolean equals(Object obj){ // we override Object's equals method
    	State s=(State) obj;
        if (this.state==s.getState())
        	return true;
        else
        	return false;
        		
    }
    
    public abstract double   GetTotalCost(SearchDomain  domain); //total cost from state through parents

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public State getCameFrom() {
		return cameFrom;
	}

	public void setCameFrom(State cameFrom) {
		this.cameFrom = cameFrom;
	}

	public int getStateRow() {
		return StateRow;
	}

	public void setStateRow(int stateRow) {
		StateRow = stateRow;
	}

	public int getStateColumn() {
		return StateColumn;
	}

	public void setStateColumn(int stateColumn) {
		StateColumn = stateColumn;
	}

	public double getG_score() {
		return g_score;
	}

	public void setG_score(double g_score) {
		this.g_score = g_score;
	}

	public double getF_score() {
		return f_score;
	}

	public void setF_score(double f_score) {
		this.f_score = f_score;
	} 
	

}