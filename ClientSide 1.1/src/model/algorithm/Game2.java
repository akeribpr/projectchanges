package model.algorithm;

import java.io.Serializable;
import java.util.Random;
import model.domains.MazeGameState;


public class Game2 implements Serializable{

	MazeGameState[][] MazeBoard;
	
	public Game2() {
		
		MazeGameState[][] MazeBoard = new MazeGameState[10][10];
		for (int  i=0;i<10;i++)
			for (int j=0;j<10;j++)
			{
				Random rand=new Random();
				int n = rand .nextInt(2)+1;
				if (n==2){
					MazeBoard[i][j]=new MazeGameState ((i*10+j),3,null,i,j);
					continue;
				}
				MazeBoard[i][j]=null;				
			}
		MazeBoard[9][9]=new MazeGameState (9999,3,null,9,9);
		MazeBoard[0][0]=new MazeGameState (0,3,null,0,0);
		this.MazeBoard=	MazeBoard;
	}

	public MazeGameState[][] getMazeBoard() {
		return MazeBoard;
	}

	public void setMazeBoard(MazeGameState[][] skiResort) {
		MazeBoard = skiResort;
	}
	
}
