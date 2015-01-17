package model.algorithm;

import java.io.Serializable;
import java.util.Random;
import model.domains.SkiGameState;

public class Game implements Serializable{

	SkiGameState[][] SkiResort;
	
	public Game() {
		
		SkiGameState[][] SkiResort = new SkiGameState[50][50];
		for (int  i=0;i<50;i++)
			for (int j=0;j<50;j++)
			{
				Random rand=new Random();
				int n = rand .nextInt(11)+1;
				if(n==11)
				{
					n=2;
					/*SkiResort[i][j]=null;
					continue;*/
				}
				if (n==3)
					n=2;
				if(n==4||n==5||n==6||n==7)
					n=3;
				if(n==8||n==9)
					n=4;
				if(n==10)
					n=5;
				SkiResort[i][j]=new SkiGameState ((i*10000+j),n,null,i,j);
			}
		SkiResort[49][49]=new SkiGameState (9999,3,null,9,9);
		SkiResort[0][0]=new SkiGameState (0,3,null,0,0);
		this.SkiResort=	SkiResort;
		}

	public SkiGameState[][] getSkiResort() {
		return SkiResort;
	}

	public void setSkiResort(SkiGameState[][] skiResort) {
		SkiResort = skiResort;
	}
	
}
