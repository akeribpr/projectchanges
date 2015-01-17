package model.domains;


import java.io.Serializable;
import java.util.HashMap;

import model.algorithm.Action;
import model.algorithm.Game;
import model.algorithm.SearchDomain;
import model.algorithm.State;




public class SkiGameDomain implements SearchDomain ,Serializable {
	
		

		SkiGameState start,goal;
		SkiGameState [][] SkiResort;
		
		//C'tors
		public SkiGameDomain(Game skigame) { 
			this.start=skigame.getSkiResort()[0][0];
			this.goal=skigame.getSkiResort()[skigame.getSkiResort().length-1][skigame.getSkiResort()[0].length-1];
			this.SkiResort=skigame.getSkiResort();
		}
		
		public SkiGameDomain(State start,State goal,SkiGameState[][] SkiResort) {
			this.start=new SkiGameState(start);
			this.goal=new SkiGameState(goal);
			this.SkiResort= SkiResort;
		}

		//setters
		public State getStartState() {
			return start;
		}

		public State getGoalState() {
			return goal;
		}
		public State[][] getMap() {
			return SkiResort;
		}
		
		@Override
		public void setGoal(State goal) {
			this.goal = (SkiGameState)goal;	
		}
		
		
		
		public HashMap<Action,State> extractSuccessors(State s) //find the next possibble actions
		{
			HashMap<Action,State> moves=new HashMap<>();
			State st=s;
			SkiGameState state= (SkiGameState) st;
			if (state.getStateRow()==SkiResort.length-1)
				return null;
			if (SkiResort[0].length-2==state.getStateColumn())
			{
				Action a=new Action ("turn right to"+SkiResort[state.getStateRow()+1][SkiResort[0].length-1]);
				moves.put(a,SkiResort[state.getStateRow()+1][SkiResort[0].length-1]);
				Action b=new Action ("turn stright to"+SkiResort[state.getStateRow()+1][SkiResort[0].length-2]);
				moves.put(b,SkiResort[state.getStateRow()+1][SkiResort[0].length-2]);
				Action c=new Action ("turn left to"+SkiResort[state.getStateRow()+1][SkiResort[0].length-3]);
				moves.put(c,SkiResort[state.getStateRow()+1][SkiResort[0].length-3]);
				Action d=new Action ("turn diagonal left to"+SkiResort[state.getStateRow()+1][SkiResort[0].length-4]);
				moves.put(d,SkiResort[state.getStateRow()+1][SkiResort[0].length-4]);
				return moves;
			}
					
			if (SkiResort[0].length-1==state.getStateColumn())
			{
				Action a=new Action ("turn stright to"+SkiResort[state.getStateRow()+1][SkiResort[0].length-1]);
				moves.put(a,SkiResort[state.getStateRow()+1][SkiResort[0].length-1]);
				Action b=new Action ("turn left to"+SkiResort[state.getStateRow()+1][SkiResort[0].length-2]);
				moves.put(b,SkiResort[state.getStateRow()+1][SkiResort[0].length-2]);
				Action c=new Action ("turn diagonal left to"+SkiResort[state.getStateRow()+1][SkiResort[0].length-3]);
				moves.put(c,SkiResort[state.getStateRow()+1][SkiResort[0].length-3]);
				return moves;
			}
		
			switch (state.getStateColumn())
			{
				case 0:{
					Action a=new Action ("turn stright to"+SkiResort[state.getStateRow()+1][0]);
					moves.put(a,SkiResort[state.getStateRow()+1][0]);
					Action b=new Action ("turn right to"+SkiResort[state.getStateRow()+1][1]);
					moves.put(b,SkiResort[state.getStateRow()+1][1]);
					Action c=new Action ("turn diagonal right to"+SkiResort[state.getStateRow()+1][2]);
					moves.put(c,SkiResort[state.getStateRow()+1][2]);
					return moves;
				}
				case 1:{
					Action a=new Action ("turn left to"+SkiResort[state.getStateRow()+1][0]);
					moves.put(a,SkiResort[state.getStateRow()+1][0]);
					Action b=new Action ("turn stright to"+SkiResort[state.getStateRow()+1][1]);
					moves.put(b,SkiResort[state.getStateRow()+1][1]);
					Action c=new Action ("turn right to"+SkiResort[state.getStateRow()+1][2]);
					moves.put(c,SkiResort[state.getStateRow()+1][2]);
					Action d=new Action ("turn diagonal right to"+SkiResort[state.getStateRow()+1][3]);
					moves.put(d,SkiResort[state.getStateRow()+1][3]);
					return moves;
				}
				
				default:{
					Action a=new Action ("turn diagonal left to"+SkiResort[state.getStateRow()+1][state.StateColumn-2]);
					moves.put(a,SkiResort[state.getStateRow()+1][state.StateColumn-2]);
					Action b=new Action ("turn left to"+SkiResort[state.getStateRow()+1][state.StateColumn-1]);
					moves.put(b,SkiResort[state.getStateRow()+1][state.StateColumn-1]);
					Action c=new Action ("turn stright to"+SkiResort[state.getStateRow()+1][state.StateColumn]);
					moves.put(c,SkiResort[state.getStateRow()+1][state.StateColumn]);
					Action d=new Action ("turn right to"+SkiResort[state.getStateRow()+1][state.StateColumn+1]);
					moves.put(d,SkiResort[state.getStateRow()+1][state.StateColumn+1]);
					Action e=new Action ("turn diagonal right to"+SkiResort[state.getStateRow()+1][state.StateColumn+2]);
					moves.put(e,SkiResort[state.getStateRow()+1][state.StateColumn+2]);
					return moves;
				}
				
			}
		
		}

		public SkiGameState getStart() {
			return start;
		}

		public void setStart(SkiGameState start) {
			this.start = start;
		}
		
		@Override
		public String getProblemDescription() {
			return SkiResort.toString();
		}

		@Override
		public void setStart(String move) {
			if (move.equals(new String("diagonalleft")))
				if (start.getStateColumn()-2>=0){
					this.start=SkiResort[start.getStateRow()+1][start.getStateColumn()-2];
					this.start.setCameFrom(SkiResort[start.getStateRow()-1][start.getStateColumn()+2]);
				}
			if (move.equals(new String("left")))
				if(start.getStateColumn()-1>=0){
					this.start=SkiResort[start.getStateRow()+1][start.getStateColumn()-1];
					this.start.setCameFrom(SkiResort[start.getStateRow()-1][start.getStateColumn()+1]);
				}
			if (move.equals(new String("stright"))){
					this.start=SkiResort[start.getStateRow()+1][start.getStateColumn()];
					this.start.setCameFrom(SkiResort[start.getStateRow()-1][start.getStateColumn()]);
			}
			if (move.equals(new String("right")))
				if(start.getStateColumn()+1<=SkiResort[0].length-1){
					this.start=SkiResort[start.getStateRow()+1][start.getStateColumn()+1];
					this.start.setCameFrom(SkiResort[start.getStateRow()-1][start.getStateColumn()-1]);
				}
			if (move.equals(new String("diagonalright")))
				if(start.getStateColumn()+2<=SkiResort[0].length-1){
					this.start=SkiResort[start.getStateRow()+1][start.getStateColumn()+2];
					this.start.setCameFrom(SkiResort[start.getStateRow()-1][start.getStateColumn()-2]);
				}
		}
			
		}

	

