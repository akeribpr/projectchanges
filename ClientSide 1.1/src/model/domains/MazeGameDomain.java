package model.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import model.algorithm.Action;
import model.algorithm.Game2;
import model.algorithm.SearchDomain;
import model.algorithm.State;

public class MazeGameDomain implements SearchDomain,Serializable {

	
	MazeGameState start,goal;
	MazeGameState [][] MazeBoard;
	private static final long serialVersionUID = 1L;
	
	//C'tors
	public MazeGameDomain(Game2 mazegame) {
		this.start=mazegame.getMazeBoard()[0][0];
		this.goal=mazegame.getMazeBoard()[mazegame.getMazeBoard().length-1][mazegame.getMazeBoard()[0].length-1];
		this.MazeBoard=mazegame.getMazeBoard();
	}
	
	public MazeGameDomain(State start,State goal,MazeGameState[][] MazeBoard) {
		this.start=new MazeGameState(start);
		this.goal=new MazeGameState(goal);
		this.MazeBoard= MazeBoard;
	}
	
	//setters
	public State getStartState() {
		return start;
	}

	public State getGoalState() {
		return goal;
	}
	public State[][] getMap() {
		return MazeBoard;
	}
	
	public void setGoal(State goal) {
		this.goal = (MazeGameState)goal;	
	}

	public HashMap<Action, State> extractSuccessors(State state) //find the next possibble actions
	{
		HashMap<Action,State> moves=new HashMap<>();
		if (state.getStateRow()==0&&state.getStateColumn()==0)
		{
			Action a=new Action ("turn right to"+MazeBoard[0][1]);
			moves.put(a,MazeBoard[0][1]);
			Action b=new Action ("turn down to"+MazeBoard[1][0]);
			moves.put(b,MazeBoard[0][1]);
			return moves;
		}
		if (state.getStateRow()==0&&state.getStateColumn()==MazeBoard[0].length-1)
		{
			Action a=new Action ("turn left to"+MazeBoard[0][MazeBoard[0].length-2]);
			moves.put(a,MazeBoard[0][MazeBoard[0].length-2]);
			Action b=new Action ("turn down to"+MazeBoard[1][MazeBoard[0].length-1]);
			moves.put(b,MazeBoard[1][MazeBoard[0].length-1]);
			return moves;
		}
		if (state.getStateRow()==MazeBoard.length-1&&state.getStateColumn()==0)
		{
			Action a=new Action ("turn up to"+MazeBoard[MazeBoard.length-2][0]);
			moves.put(a,MazeBoard[0][MazeBoard[0].length-2]);
			Action b=new Action ("turn right to"+MazeBoard[MazeBoard.length-1][1]);
			moves.put(b,MazeBoard[MazeBoard.length-1][1]);
			return moves;
		}
		if (state.getStateRow()==MazeBoard.length-1&&state.getStateColumn()==MazeBoard[0].length-1)
		{
			Action a=new Action ("turn up to"+MazeBoard[MazeBoard.length-2][MazeBoard.length-1]);
			moves.put(a,MazeBoard[MazeBoard.length-2][MazeBoard.length-1]);
			Action b=new Action ("turn left to"+MazeBoard[MazeBoard.length-1][MazeBoard.length-2]);
			moves.put(b,MazeBoard[MazeBoard.length-1][MazeBoard.length-2]);
			return moves;
		}
		if (state.getStateRow()==0)
		{
			Action a=new Action ("turn right to"+MazeBoard[0][state.StateColumn+1]);
			moves.put(a,MazeBoard[0][state.StateColumn+1]);
			Action b=new Action ("turn left to"+MazeBoard[0][state.StateColumn-1]);
			moves.put(b,MazeBoard[0][state.StateColumn-1]);
			Action c=new Action ("turn down to"+MazeBoard[1][state.StateColumn]);
			moves.put(c,MazeBoard[1][state.StateColumn]);
			return moves;
		}
		if (state.StateColumn==0)
		{
			Action a=new Action ("turn up to"+MazeBoard[state.StateRow-1][0]);
			moves.put(a,MazeBoard[state.StateRow-1][0]);
			Action b=new Action ("turn down to"+MazeBoard[state.StateRow+1][0]);
			moves.put(b,MazeBoard[state.StateRow+1][0]);
			Action c=new Action ("turn right to"+MazeBoard[state.StateRow][1]);
			moves.put(c,MazeBoard[state.StateRow][1]);
			return moves;
		}
		if (state.StateColumn==MazeBoard[0].length-1)
		{
			Action a=new Action ("turn up to"+MazeBoard[state.StateRow-1][MazeBoard[0].length-1]);
			moves.put(a,MazeBoard[state.StateRow-1][MazeBoard[0].length-1]);
			Action b=new Action ("turn down to"+MazeBoard[state.StateRow+1][MazeBoard[0].length-1]);
			moves.put(b,MazeBoard[state.StateRow+1][MazeBoard[0].length-1]);
			Action c=new Action ("turn left to"+MazeBoard[state.StateRow][MazeBoard[0].length-2]);
			moves.put(c,MazeBoard[state.StateRow][MazeBoard[0].length-2]);
			return moves;
		}
		if (state.StateRow==MazeBoard.length-1)
		{
			Action a=new Action ("turn up to"+MazeBoard[MazeBoard.length-2][state.StateColumn]);
			moves.put(a,MazeBoard[MazeBoard.length-2][state.StateColumn]);
			Action b=new Action ("turn left to"+MazeBoard[MazeBoard.length-1][state.StateColumn-1]);
			moves.put(b,MazeBoard[MazeBoard.length-1][state.StateColumn-1]);
			Action c=new Action ("turn right to"+MazeBoard[MazeBoard.length-1][state.StateColumn+1]);
			moves.put(c,MazeBoard[MazeBoard.length-1][state.StateColumn+1]);
			return moves;
		}
		Action a=new Action ("turn up to"+MazeBoard[state.StateRow-1][state.StateColumn]);
		moves.put(a,MazeBoard[state.StateRow-1][state.StateColumn]);
		Action b=new Action ("turn down to"+MazeBoard[state.StateRow+1][state.StateColumn]);
		moves.put(b,MazeBoard[state.StateRow+1][state.StateColumn]);
		Action c=new Action ("turn right to"+MazeBoard[state.StateRow][state.StateColumn+1]);
		moves.put(c,MazeBoard[state.StateRow][state.StateColumn+1]);
		Action d=new Action ("turn left to"+MazeBoard[state.StateRow][state.StateColumn-1]);
		moves.put(d,MazeBoard[state.StateRow][state.StateColumn-1]);
		return moves;
	}

	public MazeGameState getStart() {
		return start;
	}

	public void setStart(String move) {
		if (move.equals(new String("up")))
			if(start.getStateRow()>0)
				if (MazeBoard[start.getStateRow()-1][start.getStateColumn()]!=null)
					this.start=MazeBoard[start.getStateRow()-1][start.getStateColumn()];
		if (move.equals(new String("down")))
			if (start.getStateRow()+1<=MazeBoard.length-1)
				if(MazeBoard[start.getStateRow()+1][start.getStateColumn()]!=null)
					this.start=MazeBoard[start.getStateRow()+1][start.getStateColumn()];
		if (move.equals(new String("left")))
			if(start.getStateColumn()>0)
				if(MazeBoard[start.getStateRow()][start.getStateColumn()-1]!=null)
					this.start=MazeBoard[start.getStateRow()][start.getStateColumn()-1];
		if (move.equals(new String("right")))
			if(start.getStateColumn()+1<=MazeBoard[0].length-1)
				if(MazeBoard[start.getStateRow()][start.getStateColumn()+1]!=null)
					this.start=MazeBoard[start.getStateRow()][start.getStateColumn()+1];
	}
	@Override
	public String getProblemDescription() {
		return MazeBoard.toString();
	}


	@Override
	public ArrayList<Action> backTrace()
	 {
		 ArrayList<Action> moves = new ArrayList<Action>();
		 
		 State current=goal;

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
	
	

}
