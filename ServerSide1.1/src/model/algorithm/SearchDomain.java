package model.algorithm;

import java.util.ArrayList;
import java.util.HashMap;


// the expected functionality from a search problem 
public interface SearchDomain {
	
	State getStartState();
	State getGoalState();
	State[][] getMap();
	public  HashMap<Action,State> extractSuccessors(State s);
	void setGoal(State n);
    void setStart(String move);
	String getProblemDescription();
	ArrayList<Action> backTrace();
	

}
